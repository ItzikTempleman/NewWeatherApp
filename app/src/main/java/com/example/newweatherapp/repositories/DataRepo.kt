package com.example.newweatherapp.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.newweatherapp.models.forecast.ForecastResponse
import com.example.newweatherapp.models.waether.WeatherResponse
import com.example.newweatherapp.requests.Requests
import com.example.newweatherapp.requests.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataRepo {
    private val dataRequest: Requests = RetrofitInstance.getWeatherAndForecastRetrofit().create(Requests::class.java)

    fun getInstance(): DataRepo {
        return this
    }

    fun getWeather(cityName: String, units: String): MutableLiveData<WeatherResponse> {
        val weatherLiveData: MutableLiveData<WeatherResponse> = MutableLiveData()
        dataRequest.getSearchedCity(cityName, units).enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    val weatherResponse = response.body()
                    if (weatherResponse != null) {
                        weatherLiveData.value = weatherResponse
                    }
                }
            }
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
            }
        })
        return weatherLiveData
    }






    fun getForecast(cityName: String, units: String): MutableLiveData<ForecastResponse>{
        val forecastLiveData: MutableLiveData<ForecastResponse> = MutableLiveData()
        dataRequest.getSearchedCityForecast(cityName, units).enqueue(object : Callback<ForecastResponse>{
            override fun onResponse(call: Call<ForecastResponse>, response: Response<ForecastResponse>) {
                if (response.isSuccessful) {
                    val forecastResponse = response.body()
                    Log.d("TAG", "forecast response: $forecastResponse")
                    if (forecastResponse != null) {
                        forecastLiveData.value = forecastResponse
                    }
                }
            }
            override fun onFailure(call: Call<ForecastResponse>, t: Throwable) {
                Log.d("TAG", "Failure message: "+t.message.toString())
            }
        })
        return forecastLiveData
    }
}