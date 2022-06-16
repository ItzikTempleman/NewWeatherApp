package com.example.newweatherapp.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newweatherapp.databinding.ForecastItemViewBinding
import com.example.newweatherapp.models.forecast.ForecastListItem
import com.example.newweatherapp.utils.extensions.changeInnerViewsColorTo

class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    private var currentTextColors = Color.BLACK

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
        holder.binding.forecastTemperatureTv.text = forecastItem.temperature.temp.toInt().toString()
        holder.binding.forecastMainTv.text = forecastItem.forecastIconAndDesc[0].main
        holder.binding.forecastItemViewContainer changeInnerViewsColorTo currentTextColors
        if (forecastItem.getFormattedTime() != "0:00" && forecastList[position] != forecastList[0]) {
            holder.binding.forecastDayOfWeekTv.setTextColor(Color.parseColor("#00EAEAEA"))
            holder.binding.forecastDateTv.setTextColor(Color.parseColor("#00EAEAEA"))
        }
        if(forecastItem.getFormattedDayOfWeek()=="Today"||forecastItem.getFormattedDayOfWeek()=="Tomorrow"){
            holder.binding.forecastDateTv.setTextColor(Color.parseColor("#00EAEAEA"))
        }
    }

    override fun getItemCount(): Int {
        return forecastList.size
    }

    fun updateForecast(updatedList: List<ForecastListItem>) {
        forecastList.clear()
        forecastList.addAll(updatedList)
        forecastList.remove(forecastList.first())
        notifyDataSetChanged()

    }

}
