package com.example.newweatherapp.models.weather

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newweatherapp.models.forecast.ForecastListItem
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "weather_table")
data class Weather(
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
    var images: List<String> = emptyList(),

    @ColumnInfo(name = "creation_date", defaultValue = "CURRENT_TIMESTAMP")
    var creationDate: Date = Date(System.currentTimeMillis()),

    @ColumnInfo(name = "modification_date", defaultValue = "CURRENT_TIMESTAMP")
    var modificationDate: Date = Date(System.currentTimeMillis())
)
