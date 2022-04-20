package com.example.newweatherapp.models.waether

data class ListItem(
	val rain: Any?,
	val snow: Any?,
	val name: String,
	val weather: List<WeatherItem>,
	val main: Main,
	val sys: Sys,
	val wind: Wind
)
