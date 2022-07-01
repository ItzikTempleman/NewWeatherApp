package com.example.newweatherapp.repositories

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.newweatherapp.applications.MyApplication
import com.example.newweatherapp.databases.WeatherDatabase
import com.example.newweatherapp.models.weather.WeatherListItem
import com.example.newweatherapp.requests.Requests
import com.example.newweatherapp.requests.RetrofitInstance

class WeatherRepository(private val weatherDb: WeatherDatabase) {

    private val dataRequest: Requests = RetrofitInstance.getWeatherAndForecastRetrofit().create(Requests::class.java)
    private var imagesRequest: Requests = RetrofitInstance.getLocationImageRetrofit().create(Requests::class.java)

    fun getAllAddedWeather() = weatherDb.getWeatherDao().getAllAddedWeather()

    suspend fun saveWeather(weather: WeatherListItem) = weatherDb.getWeatherDao().saveWeather(weather)

    suspend fun removeWeatherItem(weather: WeatherListItem) = weatherDb.getWeatherDao().removeWeatherItem(weather)

    suspend fun getWeather(cityName: String, units: String) = dataRequest.getSearchedCity(cityName, units)

    suspend fun getForecast(cityName: String, units: String) = dataRequest.getSearchedCityForecast(cityName, units)

    suspend fun getImages(cityName: String) = imagesRequest.getImages(cityName)

    fun isConnected(context: MyApplication): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            @Suppress("DEPRECATION") val networkInfo = connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }

}


