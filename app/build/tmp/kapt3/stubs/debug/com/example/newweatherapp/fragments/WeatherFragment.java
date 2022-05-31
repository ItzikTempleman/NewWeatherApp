package com.example.newweatherapp.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0002J\b\u0010 \u001a\u00020\u000fH\u0002J\u0018\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0002J\u001a\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u000fH\u0002J\b\u0010*\u001a\u00020\u000fH\u0003J\b\u0010+\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00060\u00060\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/example/newweatherapp/fragments/WeatherFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/example/newweatherapp/databinding/FragmentWeatherBinding;", "cityName", "", "forecastAdapter", "Lcom/example/newweatherapp/adapters/ForecastAdapter;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "isSaved", "", "placeContract", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "requestPermissionLauncher", "units", "weatherViewModel", "Lcom/example/newweatherapp/viewmodels/WeatherViewModel;", "checkForPermissionAndGetCurrentLocation", "displayAllTexts", "getCityNameByLatLng", "lat", "", "lon", "getForecastAndUpdateList", "unit", "handleButtonSateWhenRemoving", "handleButtonSateWhenSaving", "initForecastRecyclerView", "loadSavedWeather", "loadWeather", "searchedCity", "currentUnits", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "requestLocationPermissionDialog", "retrieveCurrentLocation", "setListeners", "app_debug"})
public final class WeatherFragment extends androidx.fragment.app.Fragment {
    private com.example.newweatherapp.databinding.FragmentWeatherBinding binding;
    private com.example.newweatherapp.viewmodels.WeatherViewModel weatherViewModel;
    private com.example.newweatherapp.adapters.ForecastAdapter forecastAdapter;
    private java.lang.String cityName;
    private java.lang.String units = "metric";
    private boolean isSaved = false;
    private com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> requestPermissionLauncher = null;
    private final androidx.activity.result.ActivityResultLauncher<kotlin.Unit> placeContract = null;
    private java.util.HashMap _$_findViewCache;
    
    public WeatherFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initForecastRecyclerView() {
    }
    
    private final void setListeners() {
    }
    
    private final void loadSavedWeather() {
    }
    
    private final void loadWeather(java.lang.String searchedCity, java.lang.String currentUnits) {
    }
    
    private final void handleButtonSateWhenSaving() {
    }
    
    private final void handleButtonSateWhenRemoving() {
    }
    
    private final void displayAllTexts() {
    }
    
    private final void getForecastAndUpdateList(java.lang.String cityName, java.lang.String unit) {
    }
    
    private final void requestLocationPermissionDialog() {
    }
    
    private final void checkForPermissionAndGetCurrentLocation() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void retrieveCurrentLocation() {
    }
    
    private final java.lang.String getCityNameByLatLng(double lat, double lon) {
        return null;
    }
}