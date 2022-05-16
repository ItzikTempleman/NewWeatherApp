package com.example.newweatherapp.models.weather

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class Rain(
    @SerializedName("1h") val duration: Double?
)