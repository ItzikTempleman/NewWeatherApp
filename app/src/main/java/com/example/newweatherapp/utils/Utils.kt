package com.example.newweatherapp.utils

import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
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
            val tomorrow = if (calendar[Calendar.DAY_OF_WEEK] != 7)
                calendar[Calendar.DAY_OF_WEEK] + 1 else 1
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
    }
}