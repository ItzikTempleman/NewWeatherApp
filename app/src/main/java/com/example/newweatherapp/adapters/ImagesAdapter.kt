package com.example.newweatherapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newweatherapp.databinding.ImageListItemBinding
import com.example.newweatherapp.models.location_images.ResultsItem

class ImagesAdapter : RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {

    private val imageDataList = mutableListOf<String>()

    class ImageViewHolder(val binding: ImageListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ImageListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageItem = imageDataList[position]

        Glide.with(holder.itemView.context).load(imageItem).into(holder.binding.cityIv)
    }

    override fun getItemCount(): Int {
        return imageDataList.size
    }

    fun updateImageList(images: List<String>) {
        imageDataList.clear()
        imageDataList.addAll(images)
        notifyDataSetChanged()
    }
}