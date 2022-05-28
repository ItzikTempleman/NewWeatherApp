package com.example.newweatherapp.models.weather

import androidx.room.Entity
import androidx.room.PrimaryKey
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
    val weatherItem: List<WeatherItem>
)
