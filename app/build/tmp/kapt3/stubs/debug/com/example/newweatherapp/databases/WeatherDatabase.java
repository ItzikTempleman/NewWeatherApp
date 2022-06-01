package com.example.newweatherapp.databases;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.example.newweatherapp.utils.Converters.class})
@androidx.room.Database(entities = {com.example.newweatherapp.models.weather.WeatherListItem.class}, version = 1)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/newweatherapp/databases/WeatherDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getWeatherDao", "Lcom/example/newweatherapp/databases/WeatherDao;", "Companion", "app_debug"})
public abstract class WeatherDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.newweatherapp.databases.WeatherDatabase.Companion Companion = null;
    private static com.example.newweatherapp.databases.WeatherDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    private static java.util.concurrent.ExecutorService databaseWriteExecutor;
    
    public WeatherDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.newweatherapp.databases.WeatherDao getWeatherDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/example/newweatherapp/databases/WeatherDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/newweatherapp/databases/WeatherDatabase;", "databaseWriteExecutor", "Ljava/util/concurrent/ExecutorService;", "getDatabaseWriteExecutor", "()Ljava/util/concurrent/ExecutorService;", "setDatabaseWriteExecutor", "(Ljava/util/concurrent/ExecutorService;)V", "getDatabaseInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.concurrent.ExecutorService getDatabaseWriteExecutor() {
            return null;
        }
        
        public final void setDatabaseWriteExecutor(@org.jetbrains.annotations.NotNull()
        java.util.concurrent.ExecutorService p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.Synchronized()
        public final synchronized com.example.newweatherapp.databases.WeatherDatabase getDatabaseInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}