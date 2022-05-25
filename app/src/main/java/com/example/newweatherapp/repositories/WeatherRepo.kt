package com.example.newweatherapp.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.newweatherapp.MyApplication
import com.example.newweatherapp.databases.WeatherDao
import com.example.newweatherapp.databases.WeatherDatabase
import com.example.newweatherapp.models.forecast.ForecastResponse
import com.example.newweatherapp.models.weather.WeatherListItem
import com.example.newweatherapp.models.weather.WeatherResponse
import com.example.newweatherapp.requests.Requests
import com.example.newweatherapp.requests.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object WeatherRepo {

    private val dataRequest: Requests = RetrofitInstance.getWeatherAndForecastRetrofit().create(Requests::class.java)
    private val weatherDao: WeatherDao
    private val weatherDatabase = WeatherDatabase.getDatabaseInstance(MyApplication.getInstance())


    init {
        weatherDao = weatherDatabase.getWeatherDao()
    }

    fun getInstance(): WeatherRepo {
        return this
    }

    fun getWeather(cityName: String, units: String): MutableLiveData<WeatherResponse> {
         val weatherLiveData: MutableLiveData<WeatherResponse> = MutableLiveData()
        dataRequest.getSearchedCity(cityName, units).enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {

                if (response.isSuccessful) {
                    val weatherResponse = response.body()
                    weatherResponse?.let {
                        weatherLiveData.value = it
                    }
                }else{
                    // TODO: missing logic for bad request/response
                    Log.e("WOW", "onResponse: having some issues ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("WOW", t.message.toString())
            }
        })

        return weatherLiveData
    }


    fun getForecast(cityName: String, units: String): MutableLiveData<ForecastResponse> {
        val forecastLiveData: MutableLiveData<ForecastResponse> = MutableLiveData()
        dataRequest.getSearchedCityForecast(cityName, units).enqueue(object : Callback<ForecastResponse> {
            override fun onResponse(call: Call<ForecastResponse>, response: Response<ForecastResponse>) {
                if (response.isSuccessful) {
                    val forecastResponse = response.body()

                    if (forecastResponse != null) {
                        forecastLiveData.value = forecastResponse
                    }
                }
            }

            override fun onFailure(call: Call<ForecastResponse>, t: Throwable) {
                Log.d("TAG", "Failure message: " + t.message.toString())
            }
        })
        return forecastLiveData
    }


    suspend fun saveWeather(weather: WeatherListItem) = weatherDao.saveWeather(weather)

    suspend fun removeWeather(weather: WeatherListItem) = weatherDao.delete(weather)

    fun getAddedWeather() = weatherDao.getAllAddedWeather()

}
