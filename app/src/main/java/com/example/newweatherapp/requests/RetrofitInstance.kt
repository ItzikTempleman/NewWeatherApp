package com.example.newweatherapp.requests

import com.example.newweatherapp.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    fun getWeatherAndForecastRetrofit(): Retrofit {
        /*val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY*/
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(RequestInterceptor())
                    /*.addInterceptor(loggingInterceptor)*/
                    .build()
            )
            .build()
    }
}