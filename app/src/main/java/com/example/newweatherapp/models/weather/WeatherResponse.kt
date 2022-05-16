package com.example.newweatherapp.models.weather

import androidx.room.Entity


data class WeatherResponse(
	val count: Int,
	val cod: String,
	val message: String,
	val list: MutableList<WeatherListItem>
)
