package com.example.newweatherapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.iterator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newweatherapp.R
import com.example.newweatherapp.databinding.WeatherListItemBinding
import com.example.newweatherapp.fragments.WeatherFragment
import com.example.newweatherapp.models.forecast.ForecastListItem
import com.example.newweatherapp.models.weather.WeatherListItem
import com.example.newweatherapp.utils.Utils
import com.example.newweatherapp.utils.extensions.show


class WeatherAdapter(var weatherFragment: WeatherFragment) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    class WeatherViewHolder(val binding: WeatherListItemBinding) : RecyclerView.ViewHolder(binding.root)

    private var windSpeed: Int? = 0
    private val weatherList: MutableList<WeatherListItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(WeatherListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {

        val context = holder.itemView.context
        val weatherItem = weatherList[position]
        windSpeed = weatherItem.wind?.speed?.toInt()

        displayAllTexts(holder)

        handleSavedState(holder, weatherItem)

        holder.binding.saveItemIv.setOnClickListener {
            weatherItem.isSaved = !weatherItem.isSaved
            handleSavedState(holder, weatherItem)
        }

        holder.binding.forecastRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(holder.itemView.context, RecyclerView.VERTICAL, false)
            val forecastAdapter = ForecastAdapter()
            if (!weatherItem.forecastList.isNullOrEmpty()) {
                forecastAdapter.updateForecast(
                    weatherItem.forecastList ?: emptyList(),
                    weatherItem.isMetric
                )
            }
            adapter = forecastAdapter
        }

        val imageAdapter = ImageAdapter()
        imageAdapter.updateImageList(weatherItem.images ?: emptyList())
        holder.binding.imageRv.apply {
            layoutManager = GridLayoutManager(holder.itemView.context, 3)
            adapter = imageAdapter
        }


        holder.binding.cityNameTv.text = weatherItem.name
        holder.binding.countryNameTv.text = weatherItem.sys.country
        holder.binding.mainTv.text = weatherItem.weatherItems[0].description
        holder.binding.humidityValueTv.text = weatherItem.main.humidity.toString()
        holder.binding.isCurrentLocationIv.show(weatherItem.isCurrentLocation)

        if (weatherItem.isMetric) {
            holder.binding.feelsLikeValueTv.text = weatherItem.main.feels_like.toInt().toString()
            holder.binding.windValueMmTv.text = context.resources.getString(R.string.kmh)
            holder.binding.temperatureTv.text = weatherItem.main.temp.toInt().toString()
            holder.binding.windValueTv.text = (windSpeed?.times(1.6)?.toInt()).toString()
        } else {
            holder.binding.feelsLikeValueTv.text =
                Utils.celsiusToFahrenheit(weatherItem.main.feels_like).toString()
            holder.binding.temperatureTv.text =
                Utils.celsiusToFahrenheit(weatherItem.main.temp).toString()
            holder.binding.windValueMmTv.text = context.resources.getString(R.string.mh)
            holder.binding.windValueTv.text = windSpeed.toString()
        }

        if (weatherItem.rain?.duration?.toString() != null) {
            holder.binding.rainValueTv.text = weatherItem.rain.duration.toString()
        } else holder.binding.rainValueTv.text = context.getString(R.string.no_data)

        holder.binding.snowValueTv.text =
            weatherItem.snow?.toString() ?: context.getString(R.string.no_data)
        val image = weatherItem.weatherItems[0].getImage()
        Glide.with(context).load(image).into(holder.binding.iconIv)
    }

    private fun handleSavedState(holder: WeatherViewHolder, weatherItem: WeatherListItem) {
        if (weatherItem.isSaved) {
            holder.binding.saveItemIv.setImageResource(R.drawable.added)
            weatherFragment.saveWeather(weatherItem)
        } else {
            holder.binding.saveItemIv.setImageResource(R.drawable.add)
            weatherFragment.removeWeather(weatherItem)
        }
    }

    fun getTemperatureByUnits(units: String) {
        for (i in weatherList) {
            i.isMetric = units == "metric"
        }
        notifyDataSetChanged()
    }

    private fun displayAllTexts(holder: WeatherViewHolder) {
        for (i in holder.binding.innerConstraintWeatherListItem) {
            if (i is AppCompatTextView) {
                i.visibility = View.VISIBLE
            }
        }
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    fun updateWeather(weatherListItem: WeatherListItem, isCurrentLocation: Boolean) {
        if (isCurrentLocation) weatherListItem.isCurrentLocation = true
        val existTimes: Long = weatherList.sumOf { if (it.id == weatherListItem.id) 1 else 0L }
        if (isCurrentLocation && existTimes < 2 || existTimes < 1) {
            weatherList.add(weatherListItem)
            notifyDataSetChanged()
        } else {
            val weatherItem = weatherList.find { it.id == weatherListItem.id }
            val index = weatherList.indexOf(weatherItem)
            weatherList[index] = weatherListItem
            notifyItemChanged(index)
        }
    }

    fun updateWeather(weatherListItem: WeatherListItem) {
        val currentWeather = weatherList.find { it.id == weatherListItem.id }
        val position = weatherList.indexOf(currentWeather)
        if (position != -1) {
            notifyItemChanged(position)
        }
    }

    fun updateForecast(city: String, forecastList: List<ForecastListItem>) {
        val weatherItem = weatherList.find { it.name.contains(city) }
        val weatherPosition = weatherList.indexOf(weatherItem)
        weatherList.find { it.id == weatherItem?.id }?.forecastList = forecastList
        notifyItemChanged(weatherPosition)
    }
}
