package com.example.newweatherapp.utils.extensions

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.forEach
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


infix fun ViewGroup.changeInnerViewsColorTo(color: Int) {
    if (this !is RecyclerView) {
        forEach {
            when (it) {
                is AppCompatTextView ->
                    if(visibility==View.VISIBLE) {
                        it.setTextColor(color)
                    }
                is ViewGroup -> it.changeInnerViewsColorTo(color)
            }
        }
    }
}

fun RecyclerView.firstVisibleItemPosition(): Int? {
    val findFirstVisibleItemPosition = (layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
    return if(findFirstVisibleItemPosition == -1) null else findFirstVisibleItemPosition
}

fun View.show(show : Boolean = true){
    visibility = if(show) View.VISIBLE else View.GONE
}


