package com.example.newweatherapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newweatherapp.repositories.WeatherRepository

class WeatherViewModelFactory(private val repository: WeatherRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>):T {
        return WeatherViewModel(repository) as T
    }
}