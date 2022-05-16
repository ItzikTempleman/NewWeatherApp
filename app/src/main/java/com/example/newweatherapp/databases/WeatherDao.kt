package com.example.newweatherapp.databases

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import com.example.newweatherapp.models.weather.WeatherListItem
import com.example.newweatherapp.models.weather.WeatherResponse

@Dao
interface WeatherDao {

    @Insert(onConflict = REPLACE)
    fun insertWeather(weatherToInsert: WeatherListItem)

    @Query("SELECT * FROM weather_table")
    fun getWeatherTable():LiveData<WeatherListItem>




    @Query("SELECT * FROM weather_table ORDER BY name DESC")
    fun sortNameDesc(): LiveData<WeatherListItem>

    @Query("SELECT * FROM weather_table ORDER BY name ASC")
    fun sortNameAsc(): LiveData<WeatherListItem>




    @Update
    fun updateWeather(weatherToUpdate: WeatherListItem)

    @Delete
    fun deleteWeather(weatherToDelete: WeatherListItem)

    @Query("DELETE FROM weather_table")
    fun deleteAllSavedWeathers()

}