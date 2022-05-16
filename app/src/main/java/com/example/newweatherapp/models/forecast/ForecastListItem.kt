package com.example.newweatherapp.models.forecast

import com.example.newweatherapp.utils.Utils
import com.google.gson.annotations.SerializedName

data class ForecastListItem(
	val dt_txt: String,
	@SerializedName("weather")
	val forecastIconAndDesc: List<ForecastIconAndDesc>,
	@SerializedName("main")
	val temperature: Temperature
) {
	fun getFormattedDayOfWeek():String{
		return Utils.getDayOfWeek(dt_txt)
	}

	fun getFormattedDate():String{
		return Utils.getDate(dt_txt)
	}
	fun getFormattedTime():String{
		return Utils.getHourOfDay(dt_txt)
	}

}
