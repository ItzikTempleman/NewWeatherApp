package com.example.newweatherapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.iterator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newweatherapp.R
import com.example.newweatherapp.databinding.WeatherListItemBinding
import com.example.newweatherapp.models.forecast.ForecastListItem
import com.example.newweatherapp.models.weather.WeatherListItem
import com.example.newweatherapp.utils.extensions.convertTo

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private var currentUnits: String = "metric"


    class WeatherViewHolder(val binding: WeatherListItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val weatherList: MutableList<WeatherListItem> = ArrayList()
    var currentPosition = 0
    private var forecastAdapter = ForecastAdapter()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(WeatherListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val context = holder.itemView.context

        val weatherItem = weatherList[position]
        currentPosition = holder.adapterPosition
        displayAllTexts(holder)
        initForecastRV(holder)
        holder.binding.cityNameTv.text = weatherItem.name
        holder.binding.cityNameTv.text = weatherItem.name
        holder.binding.countryNameTv.text = weatherItem.sys.country
        holder.binding.mainTv.text = weatherItem.weatherItem[0].description
        holder.binding.temperatureTv.text = weatherItem.main.temp.toInt().toString()
        holder.binding.humidityValueTv.text = weatherItem.main.humidity.toString()
        holder.binding.feelsLikeValueTv.text = weatherItem.main.feels_like.toInt().toString()
        if (weatherItem.isCurrentLocation) {
            holder.binding.isCurrentLocationIv.visibility = View.VISIBLE
        }
        val windSpeed = weatherItem.wind?.speed?.convertTo(currentUnits)?.toString()
        if (weatherItem.wind?.speed?.convertTo(currentUnits) != 0.0)
            holder.binding.windValueTv.text = windSpeed?.dropLast(3)
        else holder.binding.windValueTv.text = windSpeed?.dropLast(2)

        if (weatherItem.rain?.duration?.toString() != null) {
            holder.binding.rainValueTv.text = weatherItem.rain.duration.toString()
        } else holder.binding.rainValueTv.text = context.getString(R.string.no_data)

        holder.binding.snowValueTv.text = weatherItem.snow?.toString() ?: context.getString(R.string.no_data)
        val image = weatherItem.weatherItem[0].getImage()
        Glide.with(context).load(image).into(holder.binding.iconIv)
    }

    private fun initForecastRV(holder: WeatherViewHolder) {
        holder.binding.forecastRecyclerView.apply {
            layoutManager = LinearLayoutManager(holder.itemView.context, RecyclerView.VERTICAL, false)
            adapter = forecastAdapter
        }
    }

    fun getCurrentWeather(position: Int): WeatherListItem = weatherList[position]

    private fun displayAllTexts(holder: WeatherViewHolder) {
        for (i in holder.binding.fragmentWeatherContainer) {
            if (i is AppCompatTextView) {
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
        val existTimes: Long = weatherList.sumOf { if (it.id == weatherListItem.id) 1 else 0L }
        // check if Current location AND exist times equal OR bigger than two
        if (isCurrentLocation) weatherListItem.isCurrentLocation = true
        if ((isCurrentLocation && existTimes >= 2) || alreadyExist != null) return
        else {
            weatherList.add(weatherListItem)
            //  getForecastAndUpdateList(weatherListItem.name, currentUnits)
            notifyItemChanged(weatherList.lastIndex)

        }

    }

    fun updateForecast(forecastList: List<ForecastListItem>) {
        forecastAdapter.updateForecast(forecastList)
    }
}
