package com.example.newweatherapp.models.weather;

import java.lang.System;

@androidx.room.Entity(tableName = "weather_table")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010)\u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001dJ\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u00c6\u0003Jj\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u00c6\u0001\u00a2\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00102\u001a\u000203H\u00d6\u0001J\t\u00104\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u00a8\u00065"}, d2 = {"Lcom/example/newweatherapp/models/weather/WeatherListItem;", "", "id", "", "name", "", "main", "Lcom/example/newweatherapp/models/weather/Main;", "wind", "Lcom/example/newweatherapp/models/weather/Wind;", "sys", "Lcom/example/newweatherapp/models/weather/Sys;", "rain", "Lcom/example/newweatherapp/models/weather/Rain;", "snow", "", "weatherItem", "", "Lcom/example/newweatherapp/models/weather/WeatherItem;", "(JLjava/lang/String;Lcom/example/newweatherapp/models/weather/Main;Lcom/example/newweatherapp/models/weather/Wind;Lcom/example/newweatherapp/models/weather/Sys;Lcom/example/newweatherapp/models/weather/Rain;Ljava/lang/Double;Ljava/util/List;)V", "getId", "()J", "getMain", "()Lcom/example/newweatherapp/models/weather/Main;", "getName", "()Ljava/lang/String;", "getRain", "()Lcom/example/newweatherapp/models/weather/Rain;", "getSnow", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSys", "()Lcom/example/newweatherapp/models/weather/Sys;", "getWeatherItem", "()Ljava/util/List;", "getWind", "()Lcom/example/newweatherapp/models/weather/Wind;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JLjava/lang/String;Lcom/example/newweatherapp/models/weather/Main;Lcom/example/newweatherapp/models/weather/Wind;Lcom/example/newweatherapp/models/weather/Sys;Lcom/example/newweatherapp/models/weather/Rain;Ljava/lang/Double;Ljava/util/List;)Lcom/example/newweatherapp/models/weather/WeatherListItem;", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class WeatherListItem {
    @androidx.room.PrimaryKey()
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
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
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newweatherapp.models.weather.WeatherListItem copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.models.weather.Main main, @org.jetbrains.annotations.Nullable()
    com.example.newweatherapp.models.weather.Wind wind, @org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.models.weather.Sys sys, @org.jetbrains.annotations.Nullable()
    com.example.newweatherapp.models.weather.Rain rain, @org.jetbrains.annotations.Nullable()
    java.lang.Double snow, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.newweatherapp.models.weather.WeatherItem> weatherItem) {
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
    
    public WeatherListItem(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.models.weather.Main main, @org.jetbrains.annotations.Nullable()
    com.example.newweatherapp.models.weather.Wind wind, @org.jetbrains.annotations.NotNull()
    com.example.newweatherapp.models.weather.Sys sys, @org.jetbrains.annotations.Nullable()
    com.example.newweatherapp.models.weather.Rain rain, @org.jetbrains.annotations.Nullable()
    java.lang.Double snow, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.newweatherapp.models.weather.WeatherItem> weatherItem) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newweatherapp.models.weather.Main component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newweatherapp.models.weather.Main getMain() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.newweatherapp.models.weather.Wind component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.newweatherapp.models.weather.Wind getWind() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newweatherapp.models.weather.Sys component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newweatherapp.models.weather.Sys getSys() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.newweatherapp.models.weather.Rain component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.newweatherapp.models.weather.Rain getRain() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getSnow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.newweatherapp.models.weather.WeatherItem> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.newweatherapp.models.weather.WeatherItem> getWeatherItem() {
        return null;
    }
}