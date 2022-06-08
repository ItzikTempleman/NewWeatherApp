package com.example.newweatherapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newweatherapp.models.forecast.ForecastResponse
import com.example.newweatherapp.models.location_images.ImagesResponse
import com.example.newweatherapp.models.location_images.PhotoSizesItem
import com.example.newweatherapp.models.location_images.ResultsItem
import com.example.newweatherapp.models.weather.WeatherListItem
import com.example.newweatherapp.repositories.WeatherRepo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    var weatherRepo: WeatherRepo = WeatherRepo.getInstance()
    private val forecastLiveData: MutableLiveData<ForecastResponse> = MutableLiveData()

    fun getWeather(cityName: String, units: String): MutableLiveData<WeatherListItem> {
        val weatherLiveData: MutableLiveData<WeatherListItem> = MutableLiveData()
        weatherRepo.getWeather(cityName, units).observeForever { weatherResponse ->
            if (weatherResponse != null) {
                if (weatherResponse.list.isEmpty()) return@observeForever
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
                        val highResPhoto = photoSizes?.last()?.url
                        highResPhoto?.let {
                            photos.add(highResPhoto)
                        }
                    }
                    imageLiveData.postValue(photos)
                }
            } else {

            }

        }
        return imageLiveData
    }


//    fun getImages(cityName: String): MutableLiveData<ImagesResponse> {
//        val imageLiveData: MutableLiveData<ImagesResponse> = MutableLiveData()
//        weatherRepo.getImages(cityName).observeForever {
//            if (it != null) {
//                    imageLiveData.value = it
//            }
//        }
//        return imageLiveData
//    }
















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