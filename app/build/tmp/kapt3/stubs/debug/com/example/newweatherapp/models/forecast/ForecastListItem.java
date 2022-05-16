package com.example.newweatherapp.models.forecast;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\bH\u00c6\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lcom/example/newweatherapp/models/forecast/ForecastListItem;", "", "dt_txt", "", "forecastIconAndDesc", "", "Lcom/example/newweatherapp/models/forecast/ForecastIconAndDesc;", "temperature", "Lcom/example/newweatherapp/models/forecast/Temperature;", "(Ljava/lang/String;Ljava/util/List;Lcom/example/newweatherapp/models/forecast/Temperature;)V", "getDt_txt", "()Ljava/lang/String;", "getForecastIconAndDesc", "()Ljava/util/List;", "getTemperature", "()Lcom/example/newweatherapp/models/forecast/Temperature;", "component1", "component2", "component3", "copy", "equals", "", "other", "getFormattedDate", "getFormattedDayOfWeek", "getFormattedTime", "hashCode", "", "toString", "app_debug"})
public final class ForecastListItem {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String dt_txt = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "weather")
    private final java.util.List<com.example.newweatherapp.models.forecast.ForecastIconAndDesc> forecastIconAndDesc = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "main")
    private final com.example.newweatherapp.models.forecast.Temperature temperature = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newweatherapp.models.forecast.ForecastListItem copy(@org.jetbrains.annotations.NotNull()
    java.lang.String dt_txt, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.newweatherapp.models.forecast.ForecastIconAndDesc> forecastIconAndDesc, @org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.models.forecast.Temperature temperature) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public ForecastListItem(@org.jetbrains.annotations.NotNull()
    java.lang.String dt_txt, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.newweatherapp.models.forecast.ForecastIconAndDesc> forecastIconAndDesc, @org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.models.forecast.Temperature temperature) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDt_txt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.newweatherapp.models.forecast.ForecastIconAndDesc> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.newweatherapp.models.forecast.ForecastIconAndDesc> getForecastIconAndDesc() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newweatherapp.models.forecast.Temperature component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newweatherapp.models.forecast.Temperature getTemperature() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFormattedDayOfWeek() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFormattedDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFormattedTime() {
        return null;
    }
}