package com.example.newweatherapp.models.forecast

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
@Entity(tableName = "forecast_table")
data class ForecastResponse(
	val cnt: Int,
	val cod: String,
	val message: Int,
	@SerializedName("list")
	val forecastList: List<ForecastListItem>
)
