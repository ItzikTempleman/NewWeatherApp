package com.example.newweatherapp.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0002J\b\u0010#\u001a\u00020\u0010H\u0002J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0002J\u001a\u0010\'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u0010H\u0002J\b\u0010-\u001a\u00020\u0010H\u0003J\b\u0010.\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00070\u00070\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/example/newweatherapp/fragments/WeatherFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/newweatherapp/repositories/InterfaceHandleErrorMessage;", "()V", "binding", "Lcom/example/newweatherapp/databinding/FragmentWeatherBinding;", "cityName", "", "forecastAdapter", "Lcom/example/newweatherapp/adapters/ForecastAdapter;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "menu", "Landroid/view/Menu;", "placeContract", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "requestPermissionLauncher", "units", "weatherViewModel", "Lcom/example/newweatherapp/viewmodels/WeatherViewModel;", "checkForPermissionAndGetCurrentLocation", "displayAllTexts", "getCityNameByLatLng", "lat", "", "lon", "getForecastAndUpdateList", "unit", "handleButtonSateWhenRemoving", "handleButtonSateWhenSaving", "handleError", "errorMessage", "initForecastRecyclerView", "loadSavedWeather", "loadWeather", "searchedCity", "currentUnits", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "requestLocationPermissionDialog", "retrieveCurrentLocation", "setListeners", "app_debug"})
public final class WeatherFragment extends androidx.fragment.app.Fragment implements com.example.newweatherapp.repositories.InterfaceHandleErrorMessage {
    private com.example.newweatherapp.databinding.FragmentWeatherBinding binding;
    private com.example.newweatherapp.viewmodels.WeatherViewModel weatherViewModel;
    private com.example.newweatherapp.adapters.ForecastAdapter forecastAdapter;
    private java.lang.String cityName;
    private java.lang.String units = "metric";
    private android.view.Menu menu;
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
    
    @java.lang.Override()
    public void handleError(@org.jetbrains.annotations.NotNull()
    java.lang.String errorMessage) {
    }
}