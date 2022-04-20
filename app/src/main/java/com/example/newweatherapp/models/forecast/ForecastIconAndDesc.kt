package com.example.newweatherapp.models.forecast

import com.example.newweatherapp.utils.Constants
import com.example.newweatherapp.utils.Constants.WEATHER_ICON_URL
import com.example.newweatherapp.utils.Constants.WEATHER_ICON_URL_ENDING

data class ForecastIconAndDesc(
	val icon: String,
	val main: String
) {
	fun getForecastIcon(): String {
		return WEATHER_ICON_URL + icon + WEATHER_ICON_URL_ENDING
	}
}
