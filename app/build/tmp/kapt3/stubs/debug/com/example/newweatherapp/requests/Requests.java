package com.example.newweatherapp.requests;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H\'J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H\'\u00a8\u0006\f"}, d2 = {"Lcom/example/newweatherapp/requests/Requests;", "", "getImages", "Lretrofit2/Call;", "Lcom/example/newweatherapp/models/location_images/ImagesResponse;", "cityName", "", "getSearchedCity", "Lcom/example/newweatherapp/models/weather/WeatherResponse;", "units", "getSearchedCityForecast", "Lcom/example/newweatherapp/models/forecast/ForecastResponse;", "app_debug"})
public abstract interface Requests {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "find")
    public abstract retrofit2.Call<com.example.newweatherapp.models.weather.WeatherResponse> getSearchedCity(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "q")
    java.lang.String cityName, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "units")
    java.lang.String units);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "forecast")
    public abstract retrofit2.Call<com.example.newweatherapp.models.forecast.ForecastResponse> getSearchedCityForecast(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "q")
    java.lang.String cityName, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "units")
    java.lang.String units);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "auto-complete")
    public abstract retrofit2.Call<com.example.newweatherapp.models.location_images.ImagesResponse> getImages(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "query")
    java.lang.String cityName);
}