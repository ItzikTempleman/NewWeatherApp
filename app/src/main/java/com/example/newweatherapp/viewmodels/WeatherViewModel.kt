package com.example.newweatherapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newweatherapp.models.forecast.ForecastResponse
import com.example.newweatherapp.models.location_images.PhotoSizesItem
import com.example.newweatherapp.models.location_images.ResultsItem
import com.example.newweatherapp.models.weather.WeatherListItem
import com.example.newweatherapp.repositories.WeatherRepo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    var weatherRepo: WeatherRepo = WeatherRepo.getInstance()


    fun getWeather(cityName: String, units: String): MutableLiveData<WeatherListItem> {
        val weatherLiveData: MutableLiveData<WeatherListItem> = MutableLiveData()

        viewModelScope.launch {
            val response = weatherRepo.getWeather(cityName, units)
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    weatherLiveData.value = body.list[0]
                }

                    else  Log.d("TAG", "Failure message: " + response.message())
                }
                else  Log.d("TAG", "Failure message: " + response.message())
            }

        return weatherLiveData
    }

    fun getForecast(cityName: String, units: String): MutableLiveData<ForecastResponse> {
        val forecastLiveData: MutableLiveData<ForecastResponse> = MutableLiveData()

        viewModelScope.launch {
            val response = weatherRepo.getForecast(cityName, units)
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
            val response = weatherRepo.getImages(cityName)
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    val results: List<ResultsItem> = body.data.typeAheadAutocomplete.results
                    val photos = mutableListOf<String>()
                    for (resultItem in results) {
                        val photoSizes: List<PhotoSizesItem>? = resultItem.image?.photo?.photoSizes
                        val highResPhoto = photoSizes?.get(8)?.url
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



    fun saveWeather(weather: WeatherListItem) = GlobalScope.launch {
        weatherRepo.saveWeather(weather)
    }


    fun removeWeather(weather: WeatherListItem) = GlobalScope.launch {
        weatherRepo.removeWeather(weather)
    }


    fun getAddedWeather() =GlobalScope.launch {
        weatherRepo.getAddedWeather()
    }
}