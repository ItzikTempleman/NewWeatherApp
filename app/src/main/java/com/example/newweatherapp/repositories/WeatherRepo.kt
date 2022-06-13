package com.example.newweatherapp.repositories

import com.example.newweatherapp.MyApplication
import com.example.newweatherapp.databases.WeatherDatabase
import com.example.newweatherapp.models.weather.WeatherListItem
import com.example.newweatherapp.requests.Requests
import com.example.newweatherapp.requests.RetrofitInstance

object WeatherRepo{

    private val dataRequest: Requests = RetrofitInstance.getWeatherAndForecastRetrofit().create(Requests::class.java)
    private var imagesRequest: Requests = RetrofitInstance.getLocationImageRetrofit().create(Requests::class.java)
    private val weatherDao=WeatherDatabase.getDatabaseInstance(MyApplication.getInstance()).getWeatherDao()


    fun getInstance(): WeatherRepo {
        return this
    }

    suspend fun getWeather(cityName: String, units: String) = dataRequest.getSearchedCity(cityName, units)

    suspend fun getForecast(cityName: String, units: String) = dataRequest.getSearchedCityForecast(cityName, units)

    suspend fun getImages(cityName: String) = imagesRequest.getImages(cityName)

    suspend fun saveWeather(weather: WeatherListItem) = weatherDao.saveWeather(weather)

    suspend fun removeWeather(weather: WeatherListItem) = weatherDao.delete(weather)

    suspend fun getAddedWeather()= weatherDao.getAllAddedWeather()

}


