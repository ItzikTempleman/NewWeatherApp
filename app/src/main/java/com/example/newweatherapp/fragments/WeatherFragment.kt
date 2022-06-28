package com.example.newweatherapp.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
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
import com.example.newweatherapp.databinding.FragmentWeatherBinding
import com.example.newweatherapp.models.weather.WeatherListItem
import com.example.newweatherapp.utils.extensions.firstVisibleItemPosition
import com.example.newweatherapp.viewmodels.WeatherViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*


class WeatherFragment : Fragment(R.layout.fragment_weather) {

    private lateinit var binding: FragmentWeatherBinding
   lateinit var weatherViewModel: WeatherViewModel
    private val weatherAdapter = WeatherAdapter(this)
    private var retrievedCityName: String? = null
    private var currentUnit: String
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) retrieveCurrentLocation()
            else requestLocationPermissionDialog()
        }

    init {
        currentUnit = "metric"
    }

    private val placeContract = registerForActivityResult(PlaceContract()) { place ->
        place?.name?.let { city ->
            loadWeather(city, currentUnit)
            getForecastAndUpdateList(city, currentUnit)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWeatherBinding.bind(view)
        weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())

        initRV()
        checkForPermissionAndGetCurrentLocation()
        setListeners()
    }

    private fun initRV() {
        binding.fragmentMainRecyclerView.apply {
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
        }
    }

    private fun loadWeather(cityToSearchFor: String, units: String) {
        weatherViewModel.getWeather(cityToSearchFor, currentUnit)
            .observe(viewLifecycleOwner) { weatherListItem ->
                if (units == resources.getString(R.string.metric)) {
                    weatherListItem.isMetric =true
                } else !weatherListItem.isMetric
                binding.activityMainProgressbar.visibility = View.GONE
                val isCurrentLocation = retrievedCityName == cityToSearchFor
                weatherAdapter.updateWeather(weatherListItem, isCurrentLocation)
                getForecastAndUpdateList(cityToSearchFor, currentUnit)
                getCityImage(cityToSearchFor)
                if (!isCurrentLocation)
                    binding.fragmentMainRecyclerView.smoothScrollToPosition(binding.fragmentMainRecyclerView.firstVisibleItemPosition() + 1)
            }
    }

    private fun getCityImage(cityToSearchFor: String) {
        weatherViewModel.getImagesOfCities(cityToSearchFor).observeForever { images ->
            weatherAdapter.updateImages(images as MutableList<String>)
        }
    }

    private fun getForecastAndUpdateList(searchedCity: String, currentUnits: String) {
        weatherViewModel.getForecast(searchedCity, currentUnits).observeForever {
            weatherAdapter.updateForecast(searchedCity, it.forecastList)
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
                return@addOnSuccessListener
            }
            retrievedCityName = getCityNameByLatLng(location.latitude, location.longitude)
            loadWeather(retrievedCityName ?: "", currentUnit)
            getForecastAndUpdateList(retrievedCityName ?: "", currentUnit)
            binding.fragmentMainRecyclerView.smoothScrollToPosition(0)
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

    fun saveWeather(weatherItem: WeatherListItem) {
        weatherViewModel.saveWeather(weatherItem)
    }

    fun removeWeather(weatherItem: WeatherListItem) {
        weatherViewModel.removeWeather(weatherItem)
    }
}

