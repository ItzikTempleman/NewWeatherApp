package com.example.newweatherapp.requests

import com.example.newweatherapp.utils.Constants.BASE_URL
import com.example.newweatherapp.utils.Constants.LOCATION_IMAGES_BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    fun getWeatherAndForecastRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(RequestInterceptor())
                    .build()
            )
            .build()
    }


    fun getLocationImageRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(LOCATION_IMAGES_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(LocationImagesResponseInterceptor())
                    .build()
            )
            .build()
    }
}