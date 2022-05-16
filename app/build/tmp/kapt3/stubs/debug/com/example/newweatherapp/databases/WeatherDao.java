package com.example.newweatherapp.databases;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0006H\'\u00a8\u0006\u000f"}, d2 = {"Lcom/example/newweatherapp/databases/WeatherDao;", "", "deleteAllSavedWeathers", "", "deleteWeather", "weatherToDelete", "Lcom/example/newweatherapp/models/weather/WeatherListItem;", "getWeatherTable", "Landroidx/lifecycle/LiveData;", "insertWeather", "weatherToInsert", "sortNameAsc", "sortNameDesc", "updateWeather", "weatherToUpdate", "app_debug"})
public abstract interface WeatherDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertWeather(@org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.models.weather.WeatherListItem weatherToInsert);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM weather_table")
    public abstract androidx.lifecycle.LiveData<com.example.newweatherapp.models.weather.WeatherListItem> getWeatherTable();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM weather_table ORDER BY name DESC")
    public abstract androidx.lifecycle.LiveData<com.example.newweatherapp.models.weather.WeatherListItem> sortNameDesc();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM weather_table ORDER BY name ASC")
    public abstract androidx.lifecycle.LiveData<com.example.newweatherapp.models.weather.WeatherListItem> sortNameAsc();
    
    @androidx.room.Update()
    public abstract void updateWeather(@org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.models.weather.WeatherListItem weatherToUpdate);
    
    @androidx.room.Delete()
    public abstract void deleteWeather(@org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.models.weather.WeatherListItem weatherToDelete);
    
    @androidx.room.Query(value = "DELETE FROM weather_table")
    public abstract void deleteAllSavedWeathers();
}