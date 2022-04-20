package com.example.newweatherapp.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class Utils {
    companion object {
        private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault())

        fun getDayOfWeekFromResponse(jsonDate: String): String {
            val dayOfWeek: String
            val date = simpleDateFormat.parse(jsonDate)
            val dateFormat: DateFormat = SimpleDateFormat("EEEE")
            dayOfWeek = dateFormat.format(date)
            return dayOfWeek
        }

        fun getDate(jsonDate: String): String {
            val dateOfMonth: String
            val date = simpleDateFormat.parse(jsonDate)
            val dateFormat: DateFormat = SimpleDateFormat("dd/MM/yy")
            dateOfMonth = dateFormat.format(date)
            return dateOfMonth
        }

        fun getHourOfDayFromResponse(jsonDate: String): String {
            val hour: String
            val date = simpleDateFormat.parse(jsonDate)
            val dateFormat: DateFormat = SimpleDateFormat("H:mm")
            hour = dateFormat.format(date)
            return hour
        }

    }
}