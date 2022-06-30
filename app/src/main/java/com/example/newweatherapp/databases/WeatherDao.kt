package com.example.newweatherapp.databases

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.newweatherapp.models.weather.WeatherListItem

@Dao
interface WeatherDao {

    @Insert(onConflict = REPLACE)
    suspend fun saveWeather(weatherToInsert: WeatherListItem)

    @Delete
    suspend fun removeWeatherItem(weatherToInsert: WeatherListItem)

    @Query("SELECT * FROM weather_table WHERE isSaved=1")
   fun getAllAddedWeather(): List<WeatherListItem>
}