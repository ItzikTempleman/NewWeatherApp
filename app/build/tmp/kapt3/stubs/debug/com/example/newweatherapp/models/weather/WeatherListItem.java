package com.example.newweatherapp.models.weather;

import java.lang.System;

@androidx.room.Entity(tableName = "weather_table")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\'\u001a\u00020\tH\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u00c6\u0003J\t\u0010+\u001a\u00020\u0012H\u00c6\u0003Jj\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u00c6\u0001\u00a2\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u000201H\u00d6\u0001J\t\u00102\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u00a8\u00063"}, d2 = {"Lcom/example/newweatherapp/models/weather/WeatherListItem;", "", "name", "", "main", "Lcom/example/newweatherapp/models/weather/Main;", "wind", "Lcom/example/newweatherapp/models/weather/Wind;", "sys", "Lcom/example/newweatherapp/models/weather/Sys;", "rain", "Lcom/example/newweatherapp/models/weather/Rain;", "snow", "", "weatherItem", "", "Lcom/example/newweatherapp/models/weather/WeatherItem;", "isAdded", "", "(Ljava/lang/String;Lcom/example/newweatherapp/models/weather/Main;Lcom/example/newweatherapp/models/weather/Wind;Lcom/example/newweatherapp/models/weather/Sys;Lcom/example/newweatherapp/models/weather/Rain;Ljava/lang/Double;Ljava/util/List;Z)V", "()Z", "getMain", "()Lcom/example/newweatherapp/models/weather/Main;", "getName", "()Ljava/lang/String;", "getRain", "()Lcom/example/newweatherapp/models/weather/Rain;", "getSnow", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSys", "()Lcom/example/newweatherapp/models/weather/Sys;", "getWeatherItem", "()Ljava/util/List;", "getWind", "()Lcom/example/newweatherapp/models/weather/Wind;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Lcom/example/newweatherapp/models/weather/Main;Lcom/example/newweatherapp/models/weather/Wind;Lcom/example/newweatherapp/models/weather/Sys;Lcom/example/newweatherapp/models/weather/Rain;Ljava/lang/Double;Ljava/util/List;Z)Lcom/example/newweatherapp/models/weather/WeatherListItem;", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class WeatherListItem {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.PrimaryKey()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.newweatherapp.models.weather.Main main = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.newweatherapp.models.weather.Wind wind = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.newweatherapp.models.weather.Sys sys = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.newweatherapp.models.weather.Rain rain = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double snow = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "weather")
    private final java.util.List<com.example.newweatherapp.models.weather.WeatherItem> weatherItem = null;
    private final boolean isAdded = false;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newweatherapp.models.weather.WeatherListItem copy(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.models.weather.Main main, @org.jetbrains.annotations.Nullable()
    com.example.newweatherapp.models.weather.Wind wind, @org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.models.weather.Sys sys, @org.jetbrains.annotations.Nullable()
    com.example.newweatherapp.models.weather.Rain rain, @org.jetbrains.annotations.Nullable()
    java.lang.Double snow, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.newweatherapp.models.weather.WeatherItem> weatherItem, boolean isAdded) {
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
    
    public WeatherListItem(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.models.weather.Main main, @org.jetbrains.annotations.Nullable()
    com.example.newweatherapp.models.weather.Wind wind, @org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.models.weather.Sys sys, @org.jetbrains.annotations.Nullable()
    com.example.newweatherapp.models.weather.Rain rain, @org.jetbrains.annotations.Nullable()
    java.lang.Double snow, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.newweatherapp.models.weather.WeatherItem> weatherItem, boolean isAdded) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newweatherapp.models.weather.Main component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newweatherapp.models.weather.Main getMain() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.newweatherapp.models.weather.Wind component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.newweatherapp.models.weather.Wind getWind() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newweatherapp.models.weather.Sys component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newweatherapp.models.weather.Sys getSys() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.newweatherapp.models.weather.Rain component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.newweatherapp.models.weather.Rain getRain() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getSnow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.newweatherapp.models.weather.WeatherItem> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.newweatherapp.models.weather.WeatherItem> getWeatherItem() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean isAdded() {
        return false;
    }
}