package com.example.newweatherapp.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\fH\u0002J\"\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0002J\u001a\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\tH\u0002J\b\u0010\'\u001a\u00020\tH\u0003J\b\u0010(\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\f0\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/example/newweatherapp/fragments/WeatherFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/example/newweatherapp/databinding/FragmentWeatherBinding;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "placeContract", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "requestPermissionLauncher", "", "retrievedCityName", "units", "weatherAdapter", "Lcom/example/newweatherapp/adapters/WeatherAdapter;", "weatherViewModel", "Lcom/example/newweatherapp/viewmodels/WeatherViewModel;", "checkForPermissionAndGetCurrentLocation", "getCityNameByLatLng", "lat", "", "lon", "getForecastAndUpdateList", "searchedCity", "currentUnits", "initRV", "loadImages", "loadWeather", "cityToSearchFor", "unitsChanged", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "requestLocationPermissionDialog", "retrieveCurrentLocation", "setListeners", "app_debug"})
public final class WeatherFragment extends androidx.fragment.app.Fragment {
    private com.example.newweatherapp.databinding.FragmentWeatherBinding binding;
    private com.example.newweatherapp.viewmodels.WeatherViewModel weatherViewModel;
    private final com.example.newweatherapp.adapters.WeatherAdapter weatherAdapter = null;
    private java.lang.String retrievedCityName;
    private java.lang.String units = "metric";
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
    
    private final void initRV() {
    }
    
    private final void setListeners() {
    }
    
    private final void loadImages(java.lang.String searchedCity) {
    }
    
    private final void loadWeather(java.lang.String cityToSearchFor, java.lang.String units, boolean unitsChanged) {
    }
    
    private final void getForecastAndUpdateList(java.lang.String searchedCity, java.lang.String currentUnits) {
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