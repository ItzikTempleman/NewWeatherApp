package com.example.newweatherapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newweatherapp.databases.WeatherDatabase
import com.example.newweatherapp.models.forecast.ForecastResponse
import com.example.newweatherapp.models.weather.WeatherListItem
import com.example.newweatherapp.models.weather.WeatherResponse
import com.example.newweatherapp.repositories.InterfaceHandleErrorMessage
import com.example.newweatherapp.repositories.WeatherRepo
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    var weatherRepo: WeatherRepo = WeatherRepo.getInstance()
    private val forecastLiveData: MutableLiveData<ForecastResponse> = MutableLiveData()


    fun getWeather(cityName: String, units: String): MutableLiveData<WeatherListItem> {
        val weatherLiveData: MutableLiveData<WeatherListItem> = MutableLiveData()
        weatherRepo.getWeather(cityName, units).observeForever { weatherResponse ->
            if (weatherResponse != null) {
                if(weatherResponse.list.isEmpty()) return@observeForever
                weatherLiveData.value = weatherResponse.list[0]
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


    fun getAddedWeather(): MutableLiveData<MutableList<WeatherListItem>> {
        val savedWeatherList = MutableLiveData<MutableList<WeatherListItem>>()
            weatherRepo.getAddedWeather().observeForever{
                savedWeatherList.postValue(it)
            }
        return savedWeatherList
    }
}