package com.example.newweatherapp.requests

import com.example.newweatherapp.models.forecast.ForecastResponse
import com.example.newweatherapp.models.location_images.ImagesResponse
import com.example.newweatherapp.models.weather.WeatherResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Requests {

    @GET("find")
    suspend fun getSearchedCity(@Query("q") cityName: String, @Query("units") units: String): Response<WeatherResponse>


    @GET("forecast")
    suspend  fun getSearchedCityForecast(@Query("q") cityName: String, @Query("units") units: String): Response<ForecastResponse>


    @GET("auto-complete")
    suspend fun getImages(@Query("query") cityName: String): Response<ImagesResponse>
}