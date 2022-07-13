package com.example.newweatherapp.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.newweatherapp.R
import com.example.newweatherapp.adapters.WeatherAdapter
import com.example.newweatherapp.contracts.PlaceContract
import com.example.newweatherapp.databases.WeatherDatabase
import com.example.newweatherapp.databinding.FragmentWeatherBinding
import com.example.newweatherapp.models.weather.Weather
import com.example.newweatherapp.repositories.WeatherRepository
import com.example.newweatherapp.utils.extensions.firstVisibleItemPosition
import com.example.newweatherapp.viewmodels.WeatherViewModel
import com.example.newweatherapp.viewmodels.WeatherViewModelFactory
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*


class WeatherFragment : Fragment(R.layout.fragment_weather) {

    private lateinit var binding: FragmentWeatherBinding
    private lateinit var weatherViewModel: WeatherViewModel
    private val weatherAdapter = WeatherAdapter(this)
    private var currentUnit = "metric"
    private var cityToSearch = ""
    //private var cityName = ""
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) retrieveCurrentLocation()
            else requestLocationPermissionDialog()
        }

    private val placeContract = registerForActivityResult(PlaceContract()) { place ->
        place?.name?.let { city ->
            cityToSearch = city
            weatherViewModel.getWeather(cityToSearch, currentUnit)
            getForecastAndUpdateList()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWeatherBinding.bind(view)
        val weatherRepository=WeatherRepository(WeatherDatabase.getDatabaseInstance(requireContext()))
        val factory=WeatherViewModelFactory(weatherRepository)
        weatherViewModel = ViewModelProvider(this, factory)[WeatherViewModel::class.java]
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())

        initRV()
        checkForPermissionAndGetCurrentLocation()
        setListeners()
        setObservers()
    }

    private fun initRV() {
        binding.fragmentMainRecyclerView.apply {
            itemAnimator = null
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = weatherAdapter
        }
        LinearSnapHelper().attachToRecyclerView(binding.fragmentMainRecyclerView)
    }

    private fun setListeners() {
        binding.getLocationBtn.setOnClickListener {
            binding.activityMainProgressbar.visibility = View.VISIBLE
            checkForPermissionAndGetCurrentLocation()
        }

        binding.searchCityEt.setOnClickListener {
            placeContract.launch()
        }

        binding.unitTypeRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            currentUnit = if (R.id.metric_radio_button == checkedId) {
                resources.getString(R.string.metric)
            } else {
                resources.getString(R.string.imperial)
            }
            weatherAdapter.getTemperatureByUnits(currentUnit)

            if (currentUnit == resources.getString(R.string.imperial)) {
                currentUnit = resources.getString(R.string.metric)
            }
        }
    }

    private fun setObservers() {
        weatherViewModel.getWeatherList().observe(viewLifecycleOwner) { weatherList ->
            if (weatherList.isEmpty()) return@observe
            val firstVisibleItemPosition = binding.fragmentMainRecyclerView.firstVisibleItemPosition() ?: 0
            weatherAdapter.updateWeatherList(weatherList)
            getForecastAndUpdateList()
            Handler(Looper.getMainLooper()).postDelayed({
                binding.fragmentMainRecyclerView.smoothScrollToPosition(firstVisibleItemPosition + 1)
            }, 200)
            // getCityImage(weatherList[firstVisibleItemPosition])
            binding.activityMainProgressbar.visibility = View.GONE
        }
    }

    private fun getForecastAndUpdateList() {
        weatherViewModel.getForecast(cityToSearch, currentUnit).observeForever {
            weatherAdapter.updateForecast(cityToSearch, it.forecastList)
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
                val uri: Uri = Uri.fromParts(
                    resources.getString(R.string.package_),
                    context?.packageName,
                    null
                )
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
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED -> {
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
                weatherViewModel.getSavedWeather()
                return@addOnSuccessListener
            }
            cityToSearch = getCityNameByLatLng(location.latitude, location.longitude)
            weatherViewModel.getWeather(cityToSearch, currentUnit)
            getForecastAndUpdateList()
        }.addOnFailureListener {
            Log.d("WOW", "error: ${it.message}")
        }
    }

    private fun getCityNameByLatLng(lat: Double, lon: Double): String {
        var cityNameByLatLng = ""
        val geocoder = Geocoder(requireContext(), Locale.getDefault())
        val addresses: List<Address> = geocoder.getFromLocation(lat, lon, 10)

        for (adr in addresses) {
            if (adr.locality != null && adr.locality.isNotEmpty()) {
                cityNameByLatLng = adr.locality
                break
            }
        }
        return cityNameByLatLng
    }

    fun saveWeather(weatherItem: Weather) {
        weatherViewModel.saveWeather(weatherItem)
    }

    fun removeWeather(weatherItem: Weather) {
        weatherViewModel.removeWeather(weatherItem)
    }

    private fun getCityImage(weatherListItem: Weather) {
        weatherViewModel.getImagesOfCities(weatherListItem.name).observeForever { images ->
            weatherListItem.images = images
            weatherAdapter.updateWeather(weatherListItem)
        }
    }
}

