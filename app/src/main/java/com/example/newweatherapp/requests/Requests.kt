package com.example.newweatherapp.requests

import com.example.newweatherapp.models.forecast.ForecastResponse
import com.example.newweatherapp.models.weather.WeatherResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Requests {
    @GET("find")
    fun getSearchedCity(@Query("q") cityName: String, @Query("units") units: String): Call<WeatherResponse>

    @GET("forecast")
    fun getSearchedCityForecast(@Query("q") cityName: String, @Query("units") units: String): Call<ForecastResponse>
}