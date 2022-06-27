package com.example.newweatherapp.models.weather

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newweatherapp.models.forecast.ForecastListItem
import com.google.gson.annotations.SerializedName

@Entity(tableName = "weather_table")
data class WeatherListItem(
    @PrimaryKey
    val id: Long,
    val name: String,
    val main: Main,
    val wind: Wind?,
    val sys: Sys,
    val rain: Rain?,
    val snow: Double?,
    @SerializedName("weather")
    val weatherItems: List<WeatherItem>,
    var isSaved: Boolean = false,
    var isCurrentLocation: Boolean = false,
    var isMetric: Boolean = true,
    var forecastList: List<ForecastListItem>?,
    var images: List<String>?

)
