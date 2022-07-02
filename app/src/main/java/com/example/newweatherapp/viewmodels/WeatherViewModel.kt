package com.example.newweatherapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newweatherapp.applications.MyApplication
import com.example.newweatherapp.models.forecast.ForecastResponse
import com.example.newweatherapp.models.location_images.PhotoSizesItem
import com.example.newweatherapp.models.location_images.ResultsItem
import com.example.newweatherapp.models.weather.WeatherListItem
import com.example.newweatherapp.repositories.WeatherRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {


    fun isConnected():Boolean{
        return repository.isConnected(MyApplication.getInstance() as MyApplication)
    }

    fun saveWeather(weather: WeatherListItem) = GlobalScope.launch {
        repository.saveWeather(weather)
    }
    fun removeWeather(weather: WeatherListItem) = GlobalScope.launch {
        repository.removeWeatherItem(weather)
    }


    fun getAllAddedWeatherItems() = GlobalScope.launch {
        repository.getAllAddedWeather()
    }

    fun getWeather(cityName: String, units: String): MutableLiveData<WeatherListItem> {
        val weatherLiveData: MutableLiveData<WeatherListItem> = MutableLiveData()

        viewModelScope.launch {
            val response = repository.getWeather(cityName, units)
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    weatherLiveData.value = body.list[0]
                }
                    else Log.d("TAG", "first failure message: " + response.message())
                return@launch
                }
                else  Log.d("TAG", "second failure message: " + response.message())
            return@launch
            }

        return weatherLiveData
    }

    fun getForecast(cityName: String, units: String): MutableLiveData<ForecastResponse> {
        val forecastLiveData: MutableLiveData<ForecastResponse> = MutableLiveData()

        viewModelScope.launch {
            val response = repository.getForecast(cityName, units)
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                  forecastLiveData.postValue(body)
                }
                else  Log.d("TAG", "Failure message: " + response.message())
            }
            else  Log.d("TAG", "Failure message: " + response.message())
        }
        return forecastLiveData
    }

    fun getImagesOfCities(cityName: String): MutableLiveData<List<String>> {
        val imageLiveData: MutableLiveData<List<String>> = MutableLiveData()

        viewModelScope.launch {
            val response = repository.getImages(cityName)
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    val results: List<ResultsItem> = body.data.typeAheadAutocomplete.results
                    val photos = mutableListOf<String>()
                    for (resultItem in results) {
                        val photoSizes: List<PhotoSizesItem>? = resultItem.image?.photo?.photoSizes
                        val highResPhoto = photoSizes?.last()?.url
                        highResPhoto?.let {
                            photos.add(highResPhoto)
                        }
                    }
                    imageLiveData.postValue(photos)
                }
            } else {
                Log.d("TAG", "Failure message: " + response.message())
            }

        }
        return imageLiveData
    }
}