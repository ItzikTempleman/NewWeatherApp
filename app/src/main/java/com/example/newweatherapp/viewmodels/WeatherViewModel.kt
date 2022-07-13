package com.example.newweatherapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newweatherapp.applications.MyApplication
import com.example.newweatherapp.models.forecast.ForecastResponse
import com.example.newweatherapp.models.location_images.PhotoSizesItem
import com.example.newweatherapp.models.location_images.ResultsItem
import com.example.newweatherapp.models.weather.Weather
import com.example.newweatherapp.repositories.WeatherRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val weatherListLiveData = MutableLiveData<List<Weather>>()
    // TODO: Implemented currentUnits here
    //private val currentUnits = MutableLiveData<String>()

    init {
        updateWeatherListLiveData()
    }

    private fun isConnected(): Boolean {
        return repository.isConnected(MyApplication.getInstance() as MyApplication)
    }

    fun saveWeather(weather: Weather) = GlobalScope.launch {
        repository.saveWeather(weather)
    }

    fun removeWeather(weather: Weather) = GlobalScope.launch {
        repository.removeWeatherItem(weather)
    }

    fun getSavedWeather() {
        repository.getSavedWeather().observeForever { savedWeatherList ->
            if (!savedWeatherList.isNullOrEmpty()) {
                updateWeatherListLiveData(*savedWeatherList.toTypedArray())
            }
        }
    }

    // Updating WeatherListLiveData
    private fun updateWeatherListLiveData(vararg newWeatherList: Weather) {
        val currentWeatherList = weatherListLiveData.value?.toMutableList() ?: mutableListOf()
        if (newWeatherList.isEmpty()) return
        currentWeatherList.forEach { currentWeather ->
            newWeatherList.forEach { variableCurrentWeather ->
                if (currentWeather.id == variableCurrentWeather.id) {
                    return
                }
            }
        }
        currentWeatherList.addAll(newWeatherList)
        weatherListLiveData.value = currentWeatherList
    }

    fun getWeatherList(): MutableLiveData<List<Weather>> {
        return weatherListLiveData
    }

    fun getWeather(cityName: String, units: String) {
        if (isConnected()) {
            viewModelScope.launch {
                val response = repository.getWeather(cityName, units)
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null && body.list.isNotEmpty()) {

                        val weatherItem = body.list.first()
                        updateWeatherListLiveData(weatherItem)

                    } else Log.d("TAG", "first failure message: " + response.message())
                    return@launch
                } else Log.d("TAG", "second failure message: " + response.message())
                return@launch
            }
        } else getSavedWeather()
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