package com.example.newweatherapp.models.weather


data class WeatherResponse(
	val count: Int,
	val cod: String,
	val message: String,
	val list: MutableList<Weather>
)
