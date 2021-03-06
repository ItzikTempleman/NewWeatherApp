package com.example.newweatherapp.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newweatherapp.databinding.ForecastItemViewBinding
import com.example.newweatherapp.models.forecast.ForecastListItem
import com.example.newweatherapp.utils.Utils
import com.example.newweatherapp.utils.extensions.changeInnerViewsColorTo

class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    private var dayTextColor = Color.BLACK
    private var nightTextColor = Color.WHITE
    private var isForecastMetric = true
    class ForecastViewHolder(val binding: ForecastItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    private val forecastList: MutableList<ForecastListItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(ForecastItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val forecastItem = forecastList[position]


        Glide.with(holder.itemView).load(forecastItem.forecastIconAndDesc[0].getForecastIcon()).into(holder.binding.forecastIv)
        holder.binding.forecastDateTv.text = forecastItem.getFormattedDate()
        holder.binding.forecastTimeTv.text = forecastItem.getFormattedTime()
        holder.binding.forecastDayOfWeekTv.text = forecastItem.getFormattedDayOfWeek()
        if (isForecastMetric) holder.binding.forecastTemperatureTv.text =
            forecastItem.temperature.temp.toInt().toString()
        else holder.binding.forecastTemperatureTv.text =
            Utils.celsiusToFahrenheit(forecastItem.temperature.temp).toString()


        holder.binding.forecastMainTv.text = forecastItem.forecastIconAndDesc[0].main
        val firstImage=forecastList[0].forecastIconAndDesc[0].getForecastIcon()
        if(firstImage.contains("d")){
        holder.binding.forecastItemViewContainer changeInnerViewsColorTo dayTextColor
        }else holder.binding.forecastItemViewContainer changeInnerViewsColorTo nightTextColor


        if (forecastItem.getFormattedTime() != "0:00" && forecastList[position] != forecastList[0]) {
            holder.binding.forecastDayOfWeekTv.setTextColor(Color.TRANSPARENT)
            holder.binding.forecastDateTv.setTextColor(Color.TRANSPARENT)
        }
        if (forecastItem.getFormattedDayOfWeek() == "Today" || forecastItem.getFormattedDayOfWeek() == "Tomorrow") {
            holder.binding.forecastDateTv.setTextColor(Color.TRANSPARENT)
        }
    }

    override fun getItemCount(): Int {
        return forecastList.size
    }

    fun updateForecast(updatedList: List<ForecastListItem>, isMetric: Boolean) {
        if (!isMetric) isForecastMetric = false
        forecastList.clear()
        forecastList.addAll(updatedList)
        forecastList.remove(forecastList.first())
        notifyDataSetChanged()
    }
}
