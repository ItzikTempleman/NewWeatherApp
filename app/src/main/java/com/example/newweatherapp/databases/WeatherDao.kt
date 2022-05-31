package com.example.newweatherapp.databases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    suspend fun delete(weatherToInsert: WeatherListItem)

    @Query("SELECT * FROM weather_table")
   fun getAllAddedWeather(): MutableList<WeatherListItem>

}