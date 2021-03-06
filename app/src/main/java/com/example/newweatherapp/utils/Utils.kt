package com.example.newweatherapp.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class Utils {
    companion object {
        private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

        fun getDayOfWeek(jsonDate: String): String {
            var dayOfWeek: String
            val date = simpleDateFormat.parse(jsonDate)
            val calendar = Calendar.getInstance()
            val today = calendar[Calendar.DAY_OF_WEEK]

            val tomorrow = if (today == 7) {
                1
            } else today + 1

            val givenDate = date?.day?.plus(1)
            val dateFormat = SimpleDateFormat("EEEE")
            dayOfWeek = date?.let { dateFormat.format(it) }.toString()
            if (givenDate == today) {
                dayOfWeek = "Today"
            } else if (givenDate == tomorrow) {
                dayOfWeek = "Tomorrow"
            }
            return dayOfWeek
        }


        fun getDate(jsonDate: String): String {
            val dateOfMonth: String
            val date = simpleDateFormat.parse(jsonDate)
            val dateFormat: DateFormat = SimpleDateFormat("dd/MM/yy")
            dateOfMonth = date?.let { dateFormat.format(it) }.toString()
            return dateOfMonth
        }

        fun getHourOfDay(jsonDate: String): String {
            val hour: String
            val date = simpleDateFormat.parse(jsonDate)
            val dateFormat: DateFormat = SimpleDateFormat("H:mm")
            hour = date?.let { dateFormat.format(it) }.toString()
            return hour
        }

        fun celsiusToFahrenheit(celsiusItem: Double): Int {
            val newFahrenheitItem = (celsiusItem * 9 / 5) + 32
            return newFahrenheitItem.toInt()
        }
        fun fahrenheitToCelsiusTo(fahrenheitItem: Double): Int {
            val newCelsiusItem = (fahrenheitItem * 5 / 9) - 32
            return newCelsiusItem.toInt()
        }
    }
}