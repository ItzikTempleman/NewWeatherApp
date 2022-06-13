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
import com.example.newweatherapp.utils.extensions.show

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {


    class WeatherViewHolder(val binding: WeatherListItemBinding) : RecyclerView.ViewHolder(binding.root)

private var isSaved=false
    private var unitsValue = "metric"
    private val weatherList: MutableList<WeatherListItem> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(WeatherListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val context = holder.itemView.context

        val weatherItem = weatherList[position]
        displayAllTexts(holder)
        handleSavedState(holder, weatherItem)
        holder.binding.forecastRecyclerView.apply {
            layoutManager = LinearLayoutManager(holder.itemView.context, RecyclerView.VERTICAL, false)
            val forecastAdapter = ForecastAdapter()
            if (!weatherItem.forecastList.isNullOrEmpty()) {
                forecastAdapter.updateForecast(weatherItem.forecastList ?: emptyList())
            }
            adapter = forecastAdapter
        }

        holder.binding.cityNameTv.text = weatherItem.name
        holder.binding.countryNameTv.text = weatherItem.sys.country
        holder.binding.mainTv.text = weatherItem.weatherItems[0].description
        holder.binding.temperatureTv.text = weatherItem.main.temp.toInt().toString()
        holder.binding.humidityValueTv.text = weatherItem.main.humidity.toString()
        holder.binding.feelsLikeValueTv.text = weatherItem.main.feels_like.toInt().toString()
        //if (weatherItems.isCurrentLocation) holder.binding.isCurrentLocationIv.visibility = View.VISIBLE
        holder.binding.isCurrentLocationIv.show(weatherItem.isCurrentLocation)

        if (weatherItem.isMetric) {
            unitsValue = "metric"
            holder.binding.windValueMmTv.text = holder.itemView.context.resources.getString(R.string.kmh)
        } else {
            unitsValue = "imperial"
            holder.binding.windValueMmTv.text = holder.itemView.context.resources.getString(R.string.mh)
        }

        val windSpeed = weatherItem.wind?.speed?.convertTo(unitsValue)?.toString()
        if (weatherItem.wind?.speed?.convertTo(unitsValue) != 0.0)
            holder.binding.windValueTv.text = windSpeed?.dropLast(3)
        else holder.binding.windValueTv.text = windSpeed?.dropLast(2)

        if (weatherItem.rain?.duration?.toString() != null) {
            holder.binding.rainValueTv.text = weatherItem.rain.duration.toString()
        } else holder.binding.rainValueTv.text = context.getString(R.string.no_data)

        holder.binding.snowValueTv.text = weatherItem.snow?.toString() ?: context.getString(R.string.no_data)
        val image = weatherItem.weatherItems[0].getImage()
        Glide.with(context).load(image).into(holder.binding.iconIv)
    }

    private fun handleSavedState(holder: WeatherViewHolder, weatherItem: WeatherListItem) {
       holder.binding.saveItemIv.setOnClickListener {
           isSaved=!isSaved
           if(isSaved) {
               holder.binding.saveItemIv.setImageResource(R.drawable.added_background)
               saveWeatherItem()
           }
           else{
               holder.binding.saveItemIv.setImageResource(R.drawable.add_background)
               removeWeatherItem()
           }
       }
    }

    private fun saveWeatherItem() {

    }
    private fun removeWeatherItem() {

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

    fun updateWeather(weatherListItem: WeatherListItem, isCurrentLocation: Boolean, unitChanges: Boolean = false) {

        if (isCurrentLocation) weatherListItem.isCurrentLocation = true

        val existTimes: Long = weatherList.sumOf { if (it.id == weatherListItem.id) 1 else 0L }

        if (isCurrentLocation && !unitChanges && existTimes < 2 || existTimes < 1) {
            weatherList.add(weatherListItem)
            notifyDataSetChanged()
        }else{
            // in-case the if statement wasn't triggered we want to update the current weatherListItem
            // 1. find the current WeatherListItem
            val weatherItem = weatherList.find { it.id == weatherListItem.id }
            // 2. find the index of the current WeatherListItem
            val index = weatherList.indexOf(weatherItem)
            // 3. update the current WeatherListItem!!!!!!!
            weatherList[index] = weatherListItem
            // 4. update the adapter about the concrete item changes
            notifyItemChanged(index)
        }
    }

    fun updateForecast(city: String, forecastList: List<ForecastListItem>) {
        val weatherItem = weatherList.find { it.name.contains(city) }
        val weatherPosition = weatherList.indexOf(weatherItem)
        weatherList.find { it.id == weatherItem?.id }?.forecastList = forecastList
        notifyItemChanged(weatherPosition)
    }

    fun updateImageList(city: String, images: List<String>) {
        val weatherItem = weatherList.find { it.name.contains(city) }
        val weatherPosition = weatherList.indexOf(weatherItem)
        weatherList.find { it.id == weatherItem?.id }?.images = images
        notifyItemChanged(weatherPosition)
    }
}
