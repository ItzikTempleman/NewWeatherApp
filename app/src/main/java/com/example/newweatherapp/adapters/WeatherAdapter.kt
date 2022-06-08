package com.example.newweatherapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
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


    class WeatherViewHolder(val binding: WeatherListItemBinding) : RecyclerView.ViewHolder(binding.root)

    private var currentUnits: Boolean = false
    private var unitsValue = "metric"
    private val weatherList: MutableList<WeatherListItem> = ArrayList()
    private var currentPosition = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(WeatherListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val context = holder.itemView.context

        val weatherItem = weatherList[position]
        currentPosition = holder.adapterPosition
        displayAllTexts(holder)
        //initForecastRV(holder)
        holder.binding.forecastRecyclerView.apply {
            layoutManager = LinearLayoutManager(holder.itemView.context, RecyclerView.VERTICAL, false)
            val forecastAdapter = ForecastAdapter()
            if (!weatherItem.forecastList.isNullOrEmpty()) {
                forecastAdapter.updateForecast(weatherItem.forecastList ?: emptyList())
            }
            adapter = forecastAdapter
        }
        //initImagesRV(holder)
        holder.binding.imagesRecyclerView.apply {
            val imagesAdapter = ImagesAdapter()
            if (!weatherItem.images.isNullOrEmpty()) {
                imagesAdapter.updateImageList(weatherItem.images ?: emptyList())
            }
            layoutManager = LinearLayoutManager(holder.itemView.context, RecyclerView.HORIZONTAL, false)
            adapter = imagesAdapter
        }

        holder.binding.imagesRecyclerView.addOnItemTouchListener(
            object : RecyclerView.SimpleOnItemTouchListener() {
                override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                    if (e.action == MotionEvent.ACTION_DOWN) {
                        rv.parent.requestDisallowInterceptTouchEvent(true)
                    }
                    return super.onInterceptTouchEvent(rv, e)
                }
            }
        )
        holder.binding.cityNameTv.text = weatherItem.name
        holder.binding.countryNameTv.text = weatherItem.sys.country
        holder.binding.mainTv.text = weatherItem.weatherItem[0].description
        holder.binding.temperatureTv.text = weatherItem.main.temp.toInt().toString()
        holder.binding.humidityValueTv.text = weatherItem.main.humidity.toString()
        holder.binding.feelsLikeValueTv.text = weatherItem.main.feels_like.toInt().toString()
        if (weatherItem.isCurrentLocation) holder.binding.isCurrentLocationIv.visibility = View.VISIBLE

        if (weatherItem.isMetric) {
            unitsValue = "metric"
            holder.binding.windValueMmTv.text = holder.itemView.context.resources.getString(R.string.kmh)
        } else {
            holder.binding.windValueMmTv.text = holder.itemView.context.resources.getString(R.string.mh)
            unitsValue = "imperial"
            Log.d("WOW", unitsValue)
        }

        val windSpeed = weatherItem.wind?.speed?.convertTo(unitsValue)?.toString()
        if (weatherItem.wind?.speed?.convertTo(unitsValue) != 0.0)
            holder.binding.windValueTv.text = windSpeed?.dropLast(3)
        else holder.binding.windValueTv.text = windSpeed?.dropLast(2)

        if (weatherItem.rain?.duration?.toString() != null) {
            holder.binding.rainValueTv.text = weatherItem.rain.duration.toString()
        } else holder.binding.rainValueTv.text = context.getString(R.string.no_data)

        holder.binding.snowValueTv.text = weatherItem.snow?.toString() ?: context.getString(R.string.no_data)
        val image = weatherItem.weatherItem[0].getImage()
        Glide.with(context).load(image).into(holder.binding.iconIv)
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

    fun updateWeather(weatherListItem: WeatherListItem, isCurrentLocation: Boolean) {

        val alreadyExist: WeatherListItem? = weatherList.find { it.id == weatherListItem.id }
        val existTimes: Long = weatherList.sumOf { if (it.id == weatherListItem.id) 1 else 0L }
        if (isCurrentLocation) weatherListItem.isCurrentLocation = true

        if (isCurrentLocation && existTimes >= 2 || existTimes >= 2 || alreadyExist != null) {
            weatherList.removeAt(0)
        }
        weatherList.add(weatherListItem)
        notifyDataSetChanged()
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
