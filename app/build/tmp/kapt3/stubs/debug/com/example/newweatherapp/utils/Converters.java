package com.example.newweatherapp.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006H\u0007J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0004H\u0007J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0004H\u0007\u00a8\u0006%"}, d2 = {"Lcom/example/newweatherapp/utils/Converters;", "", "()V", "fromForecastList", "", "forecastList", "", "Lcom/example/newweatherapp/models/forecast/ForecastListItem;", "fromImages", "images", "fromMain", "mainItem", "Lcom/example/newweatherapp/models/weather/Main;", "fromRain", "rain", "Lcom/example/newweatherapp/models/weather/Rain;", "fromSys", "sysItem", "Lcom/example/newweatherapp/models/weather/Sys;", "fromWeatherItem", "weatherItems", "Lcom/example/newweatherapp/models/weather/WeatherItem;", "fromWind", "windItem", "Lcom/example/newweatherapp/models/weather/Wind;", "toForecastList", "forecast", "toImages", "toMain", "mainItemAsString", "toRain", "rainItemAsString", "toSys", "sysItemAsString", "toWeatherItem", "toWind", "windItemAsString", "app_debug"})
public final class Converters {
    
    public Converters() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final java.lang.String fromWeatherItem(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.newweatherapp.models.weather.WeatherItem> weatherItems) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final java.util.List<com.example.newweatherapp.models.weather.WeatherItem> toWeatherItem(@org.jetbrains.annotations.NotNull()
    java.lang.String weatherItems) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final java.lang.String fromMain(@org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.models.weather.Main mainItem) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final com.example.newweatherapp.models.weather.Main toMain(@org.jetbrains.annotations.NotNull()
    java.lang.String mainItemAsString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final java.lang.String fromSys(@org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.models.weather.Sys sysItem) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final com.example.newweatherapp.models.weather.Sys toSys(@org.jetbrains.annotations.NotNull()
    java.lang.String sysItemAsString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final java.lang.String fromWind(@org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.models.weather.Wind windItem) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final com.example.newweatherapp.models.weather.Wind toWind(@org.jetbrains.annotations.NotNull()
    java.lang.String windItemAsString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final java.lang.String fromRain(@org.jetbrains.annotations.Nullable()
    com.example.newweatherapp.models.weather.Rain rain) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final com.example.newweatherapp.models.weather.Rain toRain(@org.jetbrains.annotations.Nullable()
    java.lang.String rainItemAsString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final java.lang.String fromForecastList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.example.newweatherapp.models.forecast.ForecastListItem> forecastList) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final java.util.List<com.example.newweatherapp.models.forecast.ForecastListItem> toForecastList(@org.jetbrains.annotations.Nullable()
    java.lang.String forecast) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final java.lang.String fromImages(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> images) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final java.util.List<java.lang.String> toImages(@org.jetbrains.annotations.Nullable()
    java.lang.String images) {
        return null;
    }
}