package com.example.newweatherapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newweatherapp.R
import com.example.newweatherapp.databinding.ForecastItemViewBinding
import com.example.newweatherapp.models.forecast.ForecastListItem

class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

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
        if (updateUnitType()) {
            holder.binding.forecastUnitTypeTv.text = "C"
        } else holder.binding.forecastUnitTypeTv.text = "F"
    }


    override fun getItemCount(): Int {
        return forecastList.size
    }

     fun updateUnitType(): Boolean {
        return true
    }

    fun updateForecast(updatedList: List<ForecastListItem>) {
        forecastList.clear()
        forecastList.addAll(updatedList)
        notifyDataSetChanged()

    }
}
