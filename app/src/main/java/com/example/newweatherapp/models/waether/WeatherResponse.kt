package com.example.newweatherapp.models.waether

data class WeatherResponse(
	val count: Int,
	val cod: String,
	val message: String,
	val list: List<ListItem>
)
