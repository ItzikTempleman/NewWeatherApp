package com.example.newweatherapp.models.weather

import androidx.room.Entity
import com.example.newweatherapp.utils.Constants.WEATHER_ICON_URL
import com.example.newweatherapp.utils.Constants.WEATHER_ICON_URL_ENDING


@Entity
data class WeatherItem(
	val main: String?,
	val description: String?,
	val icon: String?,
){
	fun getImage(): String {
		return WEATHER_ICON_URL + icon + WEATHER_ICON_URL_ENDING
	}
}
