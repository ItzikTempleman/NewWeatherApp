package com.example.newweatherapp.activities

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.newweatherapp.R
import com.example.newweatherapp.adapters.ForecastAdapter
import com.example.newweatherapp.databinding.ActivityMainBinding
import com.example.newweatherapp.viewmodels.DataViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataViewModel: DataViewModel
    private lateinit var forecastAdapter: ForecastAdapter
    private lateinit var cityName: String
    private lateinit var searchedCity: String
    private var units = "metric"
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
        if (isGranted) retrieveCurrentLocation()
        else requestLocationPermissionDialog()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dataViewModel = ViewModelProvider(this)[DataViewModel::class.java]
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        initRadioButtons()
        initForecastRecyclerView()
        setListeners()
    }

    private fun initForecastRecyclerView() {
        forecastAdapter = ForecastAdapter()
        binding.forecastRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = forecastAdapter
        }
    }

    private fun initRadioButtons() {
        val radioGroup = binding.unitTypeRadioGroup
        radioGroup.check(R.id.metric_radio_button)
        radioGroup.setOnCheckedChangeListener { _, _ ->
            units = if (radioGroup.checkedRadioButtonId == R.id.metric_radio_button) "metric" else "imperial"
            getTempByUnits(binding.temperatureTv)
        }
    }

    private fun getTempByUnits(textToUpdate: TextView) {
        dataViewModel.getWeather(binding.cityNameTv.text.toString(), units).observe(this, Observer {
            val weather = it.list[0]
            textToUpdate.text = weather.main.temp.toInt().toString()
            forecastAdapter.updateUnitType()
        })
    }

    private fun setListeners() {
        binding.getLocationBtn.setOnClickListener {
            binding.activityMainProgressbar.visibility=View.VISIBLE
            checkForPermissionAndGetCurrentLocation()
        }

        binding.searchBtn.setOnClickListener {
            binding.activityMainProgressbar.visibility=View.VISIBLE
            searchedCity = binding.searchCityEt.text.toString()
            loadWeather(searchedCity, units)
            loadForecast(searchedCity, units)
            binding.searchCityEt.text?.clear()
        }
    }

    private fun loadWeather(searchedCity: String, units: String) {
        dataViewModel.getWeather(searchedCity, units).observe(this, Observer {
            binding.activityMainProgressbar.visibility=View.GONE
            val weather = it.list[0]

            binding.cityNameTv.text = weather.name
            binding.countryNameTv.text = weather.sys.country
            binding.mainTv.text = weather.weather[0].description
            binding.temperatureTv.text = weather.main.temp.toInt().toString()
            binding.humidityValueTv.text = weather.main.humidity.toString()
            binding.feelsLikeValueTv.text = weather.main.feels_like.toInt().toString()
            if (weather.wind.speed > 0.0) binding.windValueTv.text = weather.wind.speed.toString() else binding.windValueTv.text =
                getString(R.string.no_data)
            if (weather.rain != null) binding.rainValueTv.text = weather.rain.toString() else binding.rainValueTv.text = getString(R.string.no_data)
            if (weather.snow != null) binding.snowValueTv.text = weather.snow.toString() else binding.snowValueTv.text = getString(R.string.no_data)
            Glide.with(this).load(weather.weather[0].getImage()).into(binding.iconIv)
        })
    }

    private fun loadForecast(city: String, unit: String) {
        dataViewModel.getForecast(city, unit).observeForever {
            forecastAdapter.updateForecast(it.forecastList)
            Log.d("wow", "forecastAdapter: $it")
        }
    }























    private fun requestLocationPermissionDialog() {
        AlertDialog.Builder(this)
            .setTitle("Location Permission Needed")
            .setMessage("This app needs the Location permission, please accept to use location functionality")
            .setPositiveButton(
                "OK"
            ) { _, _ ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri: Uri = Uri.fromParts("package", packageName, null)
                intent.data = uri
                startActivity(intent)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

    private fun checkForPermissionAndGetCurrentLocation() {
        when {
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED -> {
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
            loadForecast(cityName, units)
        }
    }

    private fun getCityNameByLatLng(lat: Double, lon: Double): String {
        var cityName = ""
        val geocoder = Geocoder(this, Locale.getDefault())
        val addresses: List<Address> = geocoder.getFromLocation(lat, lon, 10)

        for (adr in addresses) {
            if (adr.locality != null && adr.locality.isNotEmpty()) {
                cityName = adr.locality
                break
            }
        }
        return cityName
    }
}
