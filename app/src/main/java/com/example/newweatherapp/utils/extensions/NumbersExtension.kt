package com.example.newweatherapp.utils.extensions

fun Double.convertTo(unitType: String): Double {
     return if (unitType == "metric") return String.format("%.2f", (this * 3.6)).toDouble() else this
}