package com.example.newweatherapp.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newweatherapp.models.weather.Weather
import com.example.newweatherapp.utils.Converters
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = [Weather::class], version = 1)
@TypeConverters(Converters::class)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun getWeatherDao(): WeatherDao

    companion object {

        private var INSTANCE: WeatherDatabase? = null
        var databaseWriteExecutor: ExecutorService = Executors.newFixedThreadPool(4)
        @Synchronized
        fun getDatabaseInstance(context: Context): WeatherDatabase {
                if (INSTANCE == null)
                    INSTANCE = Room.databaseBuilder(context.applicationContext, WeatherDatabase::class.java, "weather_database").build()
                return INSTANCE!!
            }
        }
    }

