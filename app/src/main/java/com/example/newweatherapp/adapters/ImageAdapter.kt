package com.example.newweatherapp.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newweatherapp.databinding.ImageListItemBinding


class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(val binding: ImageListItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val imageList: MutableList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ImageListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = imageList[position]
        Glide.with(holder.itemView).load(image).into(holder.binding.imageIv)
    }

    override fun getItemCount(): Int {
        return imageList.size

    }

    fun updateImageList(imagesList: List<String>) {
        imageList.clear()
        imageList.addAll(imagesList)
        notifyDataSetChanged()
    }
}