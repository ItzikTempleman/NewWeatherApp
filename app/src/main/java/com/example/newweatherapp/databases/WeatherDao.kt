package com.example.newweatherapp.databases

import androidx.lifecycle.LiveData
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

    // only for saved weather items (irrelevant for current implementation)
    //@Query("SELECT * FROM weather_table WHERE isSaved=1")
    @Query("SELECT * FROM weather_table")
    fun getAllAddedWeather(): LiveData<List<WeatherListItem>>

    @Query("UPDATE weather_table SET isSaved = isSaved WHERE id=:id")
    fun updateWeatherIsSaved(id: Long)

    @Query("SELECT * FROM weather_table WHERE id=:id")
    fun getWeatherById(id: Long): List<WeatherListItem>

    suspend fun insertOrUpdate(weatherListItem: WeatherListItem) {
        val weatherItem = getWeatherById(weatherListItem.id)
        if (weatherItem.isEmpty())
            saveWeather(weatherListItem)
        else
            updateWeatherIsSaved(weatherListItem.id)
    }
}