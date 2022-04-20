package com.example.newweatherapp.models.forecast

import com.google.gson.annotations.SerializedName

data class ForecastResponse(
	val cnt: Int,
	val cod: String,
	val message: Int,
	@SerializedName("list")
	val forecastList: List<ForecastListItem>
)
