package com.example.newweatherapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newweatherapp.models.forecast.ForecastResponse
import com.example.newweatherapp.models.weather.WeatherListItem
import com.example.newweatherapp.models.weather.WeatherResponse
import com.example.newweatherapp.repositories.WeatherRepo

class WeatherViewodel : ViewModel() {
    var dataRepo: WeatherRepo = WeatherRepo.getInstance()
    private val forecastLiveData: MutableLiveData<ForecastResponse> = MutableLiveData()


    fun getWeather(cityName: String, units: String): MutableLiveData<WeatherResponse> {
       val weatherLiveData: MutableLiveData<WeatherResponse> = MutableLiveData()
        dataRepo.getWeather(cityName, units).observeForever { weatherResponse ->
            if (weatherResponse != null) {
                weatherLiveData.value = weatherResponse
            }
        }
        return weatherLiveData
    }

    fun getForecast(cityName: String, units: String): MutableLiveData<ForecastResponse> {
        dataRepo.getForecast(cityName, units).observeForever {
            if (it != null) {
                forecastLiveData.value = it

            }
        }
        return forecastLiveData
    }

    fun saveWeather(weather: WeatherListItem){
        dataRepo.saveWeatherToTable(weather)
    }
}