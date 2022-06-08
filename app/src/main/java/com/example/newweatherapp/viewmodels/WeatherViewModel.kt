package com.example.newweatherapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newweatherapp.models.forecast.ForecastResponse
import com.example.newweatherapp.models.location_images.ImagesResponse
import com.example.newweatherapp.models.weather.WeatherListItem
import com.example.newweatherapp.repositories.WeatherRepo
import com.example.newweatherapp.utils.Resource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class WeatherViewModel : ViewModel() {
    var weatherRepo: WeatherRepo = WeatherRepo.getInstance()
    private val forecastLiveData: MutableLiveData<ForecastResponse> = MutableLiveData()
    val images: MutableLiveData<Resource<ImagesResponse>> = MutableLiveData()


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

    fun getImagesOfCities(cityName: String) = viewModelScope.launch {
        images.postValue(Resource.Loading())
        val response = weatherRepo.getImages(cityName)
        images.postValue(handleImagesResponse(response))
    }


    private fun handleImagesResponse(response: Response<ImagesResponse>): Resource<ImagesResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
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