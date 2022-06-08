package com.example.newweatherapp.requests;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\'J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/newweatherapp/requests/Requests;", "", "getImages", "Lretrofit2/Response;", "Lcom/example/newweatherapp/models/location_images/ImagesResponse;", "cityName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchedCity", "Lretrofit2/Call;", "Lcom/example/newweatherapp/models/weather/WeatherResponse;", "units", "getSearchedCityForecast", "Lcom/example/newweatherapp/models/forecast/ForecastResponse;", "app_debug"})
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
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "auto-complete")
    public abstract java.lang.Object getImages(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "query")
    java.lang.String cityName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.newweatherapp.models.location_images.ImagesResponse>> continuation);
}