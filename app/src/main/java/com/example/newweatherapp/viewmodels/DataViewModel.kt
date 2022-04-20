package com.example.newweatherapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newweatherapp.models.forecast.ForecastListItem
import com.example.newweatherapp.models.forecast.ForecastResponse
import com.example.newweatherapp.models.waether.WeatherResponse
import com.example.newweatherapp.repositories.DataRepo

class DataViewModel : ViewModel() {
    var dataRepo: DataRepo = DataRepo.getInstance()
    private val weatherLiveData: MutableLiveData<WeatherResponse> = MutableLiveData()
    private val forecastLiveData: MutableLiveData<ForecastResponse> = MutableLiveData()

    fun getWeather(cityName: String, units: String): MutableLiveData<WeatherResponse> {
        dataRepo.getWeather(cityName, units).observeForever {
            if (it != null) {
                weatherLiveData.value = it
            }
        }
        return weatherLiveData
    }

    fun getForecast(cityName: String, units: String): MutableLiveData<ForecastResponse> {
        dataRepo.getForecast(cityName, units).observeForever {
            if(it!=null){
             forecastLiveData.value=it
                Log.d("TAG", "it: $it")
            }
        }
        return forecastLiveData
    }
}