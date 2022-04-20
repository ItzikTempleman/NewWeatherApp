package com.example.newweatherapp.models.waether

import com.example.newweatherapp.utils.Constants.WEATHER_ICON_URL
import com.example.newweatherapp.utils.Constants.WEATHER_ICON_URL_ENDING

data class WeatherItem(
	val icon: String,
	val description: String,
	val main: String,
){
	fun getImage(): String {
		return WEATHER_ICON_URL + icon + WEATHER_ICON_URL_ENDING
	}
}
