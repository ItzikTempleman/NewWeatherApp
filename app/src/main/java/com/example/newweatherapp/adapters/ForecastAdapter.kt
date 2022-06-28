package com.example.newweatherapp.adapters

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newweatherapp.databinding.ForecastItemViewBinding
import com.example.newweatherapp.models.forecast.ForecastListItem
import com.example.newweatherapp.utils.Utils
import com.example.newweatherapp.utils.extensions.changeInnerViewsColorTo

class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    private var currentTextColors = Color.BLACK
    private var isForecastMetric = true
    class ForecastViewHolder(val binding: ForecastItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    private val forecastList: MutableList<ForecastListItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(ForecastItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val forecastItem = forecastList[position]

        Glide.with(holder.itemView).load(forecastItem.forecastIconAndDesc[0].getForecastIcon())
            .into(holder.binding.forecastIv)
        holder.binding.forecastDateTv.text = forecastItem.getFormattedDate()
        holder.binding.forecastTimeTv.text = forecastItem.getFormattedTime()
        holder.binding.forecastDayOfWeekTv.text = forecastItem.getFormattedDayOfWeek()
        if (isForecastMetric) holder.binding.forecastTemperatureTv.text =
            forecastItem.temperature.temp.toInt().toString()
        else holder.binding.forecastTemperatureTv.text =
            Utils.celsiusToFahrenheit(forecastItem.temperature.temp).toString()

        holder.binding.forecastMainTv.text = forecastItem.forecastIconAndDesc[0].main
        holder.binding.forecastItemViewContainer changeInnerViewsColorTo currentTextColors
        Log.d("WOW", "time: ${forecastItem.getFormattedTime()}")
        if (forecastItem.getFormattedTime() != "0:00" && forecastList[position] != forecastList[0]) {
            holder.binding.forecastDayOfWeekTv.setTextColor(Color.parseColor("#00EAEAEA"))
            holder.binding.forecastDateTv.setTextColor(Color.parseColor("#00EAEAEA"))

        }
        if (forecastItem.getFormattedDayOfWeek() == "Today" || forecastItem.getFormattedDayOfWeek() == "Tomorrow") {
            holder.binding.forecastDateTv.setTextColor(Color.parseColor("#00EAEAEA"))
        }
        if(forecastItem.getFormattedTime()!=="0:00"){
            holder.binding.forecastListItemBottomView.visibility=View.VISIBLE
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
