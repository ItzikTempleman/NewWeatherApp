package com.example.newweatherapp.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.view.iterator
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newweatherapp.R
import com.example.newweatherapp.databinding.WeatherListItemBinding
import com.example.newweatherapp.models.weather.WeatherListItem
import com.example.newweatherapp.utils.extensions.changeInnerViewsColorTo
import com.example.newweatherapp.utils.extensions.convertTo

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private var currentUnits: String = "metric"
    private var currentTextColors = Color.BLACK

    class WeatherViewHolder(val binding: WeatherListItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val weatherList: MutableList<WeatherListItem> = ArrayList()
    var currentPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(WeatherListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val context = holder.itemView.context

        val weatherItem = weatherList[position]
        currentPosition = holder.adapterPosition
        displayAllTexts(holder)

        holder.binding.cityNameTv.text = weatherItem.name
        holder.binding.cityNameTv.text = weatherItem.name
        holder.binding.countryNameTv.text = weatherItem.sys.country
        holder.binding.mainTv.text = weatherItem.weatherItem[0].description
        holder.binding.temperatureTv.text = weatherItem.main.temp.toInt().toString()
        holder.binding.humidityValueTv.text = weatherItem.main.humidity.toString()
        holder.binding.feelsLikeValueTv.text = weatherItem.main.feels_like.toInt().toString()

        val windSpeed = weatherItem.wind?.speed?.convertTo(currentUnits)?.toString()
        if (weatherItem.wind?.speed?.convertTo(currentUnits) != 0.0)
            holder.binding.windValueTv.text = windSpeed?.dropLast(3)
        else holder.binding.windValueTv.text = windSpeed?.dropLast(2)

        if (weatherItem.rain?.duration?.toString() != null) {
            holder.binding.rainValueTv.text = weatherItem.rain.duration.toString()
        } else holder.binding.rainValueTv.text = context.getString(R.string.no_data)

        holder.binding.snowValueTv.text = weatherItem.snow?.toString() ?: context.getString(R.string.no_data)
        val image = weatherItem.weatherItem[0].getImage()
        val icon = weatherItem.weatherItem[0].icon
        Glide.with(context).load(image).into(holder.binding.iconIv)

        if (icon != null) {
            when {
                icon.contains("d") -> {
                    holder.binding.fragmentWeatherContainer.background = ContextCompat.getDrawable(context, R.drawable.day_gradient)
                    holder.binding.fragmentWeatherContainer changeInnerViewsColorTo Color.BLACK
                    //forecastAdapter.changeTextColorsTo(Color.BLACK)
                    //holder.binding.toolbar.background = ContextCompat.getDrawable(context, R.color.very_light_blue)
                }
                icon.contains("n") -> {
                    holder.binding.fragmentWeatherContainer.background = ContextCompat.getDrawable(context, R.drawable.night_gradient)
                    holder.binding.fragmentWeatherContainer changeInnerViewsColorTo Color.WHITE
                    //forecastAdapter.changeTextColorsTo(Color.WHITE)
                    //holder.binding.toolbar.background = ContextCompat.getDrawable(context, R.color.very_light__purple)
                }
            }
        }
        //getForecastAndUpdateList(searchedCity, currentUnits)

    }

    fun getCurrentWeather(position: Int): WeatherListItem = weatherList[position]

    private fun displayAllTexts(holder: WeatherViewHolder) {
        holder.binding.horizontalBottomLine.visibility = View.VISIBLE
        for (i in holder.binding.fragmentWeatherContainer) {
            if (i is AppCompatTextView) {
                i.setTextColor(Color.parseColor("#42000000"))
                i.visibility = View.VISIBLE
            }
        }
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    fun updateWeather(weatherListItem: WeatherListItem, currentUnits: String, isCurrentLocation: Boolean) {
        this.currentUnits = currentUnits
        // check if WeatherListItem already exist (in-case it's not the current location)
        val alreadyExist = weatherList.find { it.id == weatherListItem.id }
        // Sum number of current location found
        val existTimes: Long = weatherList.sumOf { if(it.id == weatherListItem.id) 1 else 0L }
        // check if Current location AND exist times equal OR bigger than two
        if ((isCurrentLocation && existTimes >= 2) || alreadyExist != null) return
        else {
            weatherList.add(weatherListItem)
            notifyItemChanged(weatherList.lastIndex)
        }

    }
}
