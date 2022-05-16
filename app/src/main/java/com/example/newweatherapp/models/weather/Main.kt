package com.example.newweatherapp.models.weather

import androidx.room.Entity

@Entity
data class Main(
	val temp: Double,
	val feels_like: Double,
	val humidity: Int
)
