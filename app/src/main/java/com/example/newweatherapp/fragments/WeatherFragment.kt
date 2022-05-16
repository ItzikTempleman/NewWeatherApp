package com.example.newweatherapp.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.view.iterator
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newweatherapp.R
import com.example.newweatherapp.adapters.ForecastAdapter
import com.example.newweatherapp.databinding.FragmentWeatherBinding
import com.example.newweatherapp.utils.extensions.changeInnerViewsColorTo
import com.example.newweatherapp.utils.extensions.convertTo
import com.example.newweatherapp.viewmodels.WeatherViewodel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.AutocompleteActivity
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode
import java.util.*

class WeatherFragment : Fragment(R.layout.fragment_weather) {

    private lateinit var binding: FragmentWeatherBinding
    private lateinit var weatherViewModel: WeatherViewodel
    private lateinit var forecastAdapter: ForecastAdapter
    private lateinit var cityName: String
    private var units = "metric"
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
        if (isGranted) retrieveCurrentLocation()
        else requestLocationPermissionDialog()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWeatherBinding.bind(view)
        weatherViewModel = ViewModelProvider(this)[WeatherViewodel::class.java]
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())

        checkForPermissionAndGetCurrentLocation()
        initForecastRecyclerView()
        setListeners()
    }

    private fun initForecastRecyclerView() {
        forecastAdapter = ForecastAdapter()
        binding.forecastRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = forecastAdapter
            //addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.HORIZONTAL))
        }
    }

    private fun setListeners() {
        binding.getLocationBtn.setOnClickListener {
            binding.activityMainProgressbar.visibility = View.VISIBLE
            checkForPermissionAndGetCurrentLocation()
        }

        binding.searchCityEt.setOnClickListener {
            initAutoComplete()
        }

        binding.unitTypeRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            units = if (R.id.metric_radio_button == checkedId) {
                binding.windValueMmTv.text = resources.getString(R.string.kmh)
                resources.getString(R.string.metric)
            } else {
                binding.windValueMmTv.text = resources.getString(R.string.mh)
                resources.getString(R.string.imperial)

            }
            loadWeather(binding.cityNameTv.text.toString(), units)
        }

    }

    private fun initAutoComplete() {
        if (!Places.isInitialized()) {
            Places.initialize(requireContext(), getString(R.string.places_api_key))
        }
        Places.createClient(requireContext())
        val fields = listOf(Place.Field.ID, Place.Field.NAME)
        val intent = Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, fields).build(requireContext())
        startActivityForResult(intent, 1);
    }

    private fun loadWeather(searchedCity: String, currentUnits: String) {
        weatherViewModel.getWeather(searchedCity, currentUnits).observe(viewLifecycleOwner) {
            binding.activityMainProgressbar.visibility = View.GONE
            displayAllTexts()
            if (it.list.isNullOrEmpty()) return@observe
            val weather = it.list[0]
            binding.cityNameTv.text = weather.name
            binding.countryNameTv.text = weather.sys.country
            binding.mainTv.text = weather.weatherItem[0].description
            binding.temperatureTv.text = weather.main.temp.toInt().toString()
            binding.humidityValueTv.text = weather.main.humidity.toString()
            binding.feelsLikeValueTv.text = weather.main.feels_like.toInt().toString()

            val windSpeed = weather.wind?.speed?.convertTo(currentUnits)?.toString()
            if (weather.wind?.speed?.convertTo(currentUnits) != 0.0)
                binding.windValueTv.text = windSpeed?.dropLast(3)
            else binding.windValueTv.text = windSpeed?.dropLast(2)

            binding.rainValueTv.text = weather.rain?.duration?.toString() ?: getString(R.string.no_data)
            binding.snowValueTv.text = weather.snow?.toString() ?: getString(R.string.no_data)
            val image = weather.weatherItem[0].getImage()
            val icon = weather.weatherItem[0].icon
            Glide.with(this).load(image).into(binding.iconIv)

            if (icon != null) {
                when {
                    icon.contains("d") -> {
                        binding.fragmentWeatherContainer.background = ContextCompat.getDrawable(requireContext(), R.drawable.day_gradient)
                        binding.fragmentWeatherContainer changeInnerViewsColorTo Color.BLACK
                        forecastAdapter.changeTextColorsTo(Color.BLACK)
                    }
                    icon.contains("n") -> {
                        binding.fragmentWeatherContainer.background = ContextCompat.getDrawable(requireContext(), R.drawable.night_gradient)
                        binding.fragmentWeatherContainer changeInnerViewsColorTo Color.WHITE
                        forecastAdapter.changeTextColorsTo(Color.WHITE)
                    }
                }
            }
            getForecastAndUpdateList(cityName, currentUnits)
        }
    }

    private fun displayAllTexts() {
        for (i in binding.fragmentWeatherContainer) {
            if (i is AppCompatTextView) {
                i.setTextColor(Color.parseColor("#42000000"))
                i.visibility = View.VISIBLE
            }
        }
    }

    private fun getForecastAndUpdateList(cityName: String, unit: String) {
        weatherViewModel.getForecast(cityName, unit).observeForever {
            forecastAdapter.updateForecast(it.forecastList)

        }
    }

    private fun requestLocationPermissionDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(resources.getString(R.string.needs_location))
            .setMessage(resources.getString(R.string.must_permit_location))
            .setPositiveButton(
                resources.getString(R.string.ok)
            ) { _, _ ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri: Uri = Uri.fromParts(resources.getString(R.string.package_), context?.packageName, null)
                intent.data = uri
                startActivity(intent)
            }
            .setNegativeButton(resources.getString(R.string.cancel)) { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

    private fun checkForPermissionAndGetCurrentLocation() {
        when {
            ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED -> {
                retrieveCurrentLocation()
            }
            shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION) -> {
                requestLocationPermissionDialog()
            }
            else -> {
                requestPermissionLauncher.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun retrieveCurrentLocation() {
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if (location == null) {
                return@addOnSuccessListener
            }
            cityName = getCityNameByLatLng(location.latitude, location.longitude)

            loadWeather(cityName, units)

        }
    }

    private fun getCityNameByLatLng(lat: Double, lon: Double): String {
        var cityName = ""
        val geocoder = Geocoder(requireContext(), Locale.getDefault())
        val addresses: List<Address> = geocoder.getFromLocation(lat, lon, 10)

        for (adr in addresses) {
            if (adr.locality != null && adr.locality.isNotEmpty()) {
                cityName = adr.locality
                break
            }
        }
        return cityName
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    data?.let {
                        val place = Autocomplete.getPlaceFromIntent(data)
                        place.name?.let { city ->
                            loadWeather(city, units)
                        }
                    }
                }
                AutocompleteActivity.RESULT_ERROR -> {
                    data?.let {
                        val status = Autocomplete.getStatusFromIntent(data)
                    }
                }
                Activity.RESULT_CANCELED -> {
                }
            }
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
