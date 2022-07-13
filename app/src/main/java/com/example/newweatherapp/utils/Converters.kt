package com.example.newweatherapp.utils

import androidx.room.TypeConverter
import com.example.newweatherapp.models.forecast.ForecastListItem
import com.example.newweatherapp.models.weather.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*


class Converters {
    @TypeConverter
    fun fromWeatherItem(weatherItems: List<WeatherItem>): String {
        return Gson().toJson(weatherItems)
    }

    @TypeConverter
    fun toWeatherItem(weatherItems: String): List<WeatherItem> {
       return Gson().fromJson(weatherItems, object : TypeToken<List<WeatherItem>>() {}.type)
    }

    @TypeConverter
    fun fromMain(mainItem: Main): String {
        return Gson().toJson(mainItem)
    }

    @TypeConverter
    fun toMain(mainItemAsString: String): Main {
        return Gson().fromJson(mainItemAsString, Main::class.java)
    }

    @TypeConverter
    fun fromSys(sysItem: Sys): String {
        return Gson().toJson(sysItem)
    }

    @TypeConverter
    fun toSys(sysItemAsString: String): Sys {
        return Gson().fromJson(sysItemAsString, Sys::class.java)
    }

    @TypeConverter
    fun fromWind(windItem: Wind): String {
        return Gson().toJson(windItem)
    }

    @TypeConverter
    fun toWind(windItemAsString: String): Wind {
        return Gson().fromJson(windItemAsString, Wind::class.java)
    }

    @TypeConverter
    fun fromRain(rain: Rain?): String {
        return Gson().toJson(rain)
    }

    @TypeConverter
    fun toRain(rainItemAsString: String?): Rain? {
        return Gson().fromJson(rainItemAsString, Rain::class.java)
    }

    @TypeConverter
    fun fromForecastList(forecastList: List<ForecastListItem>?): String {
        return Gson().toJson(forecastList)
    }

    @TypeConverter
    fun toForecastList(forecast: String?): List<ForecastListItem> {
        return Gson().fromJson(forecast, object : TypeToken<MutableList<ForecastListItem>>() {}.type)
    }

    @TypeConverter
    fun fromImages(images: List<String>?): String {
        return Gson().toJson(images)
    }

    @TypeConverter
    fun toImages(images: String?): List<String> {
        return Gson().fromJson(images, object : TypeToken<MutableList<String>>() {}.type) ?: emptyList()
    }

    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return timestamp?.let { Date(it) }
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }

}