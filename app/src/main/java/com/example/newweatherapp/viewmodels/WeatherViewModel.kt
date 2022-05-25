package com.example.newweatherapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newweatherapp.models.forecast.ForecastResponse
import com.example.newweatherapp.models.weather.WeatherListItem
import com.example.newweatherapp.models.weather.WeatherResponse
import com.example.newweatherapp.repositories.WeatherRepo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    var weatherRepo: WeatherRepo = WeatherRepo.getInstance()
    private val forecastLiveData: MutableLiveData<ForecastResponse> = MutableLiveData()


    fun getWeather(cityName: String, units: String): MutableLiveData<WeatherResponse> {
        val weatherLiveData: MutableLiveData<WeatherResponse> = MutableLiveData()
        weatherRepo.getWeather(cityName, units).observeForever { weatherResponse ->
            if (weatherResponse != null) {
                weatherLiveData.value = weatherResponse
            }
        }
        return weatherLiveData
    }

    fun getForecast(cityName: String, units: String): MutableLiveData<ForecastResponse> {
        weatherRepo.getForecast(cityName, units).observeForever {
            if (it != null) {
                forecastLiveData.value = it

            }
        }
        return forecastLiveData
    }


    fun saveWeather(weather: WeatherListItem) = GlobalScope.launch {
        weatherRepo.saveWeather(weather)
    }


    fun removeWeather(weather: WeatherListItem) = GlobalScope.launch {
        weatherRepo.removeWeather(weather)
    }

    fun getAllSavedWeather() = weatherRepo.getAddedWeather()
}