package com.example.newweatherapp.utils.extensions

import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.forEach
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.*
import kotlin.reflect.KClass


infix fun ViewGroup.changeInnerViewsColorTo(color: Int) {
    // prevent changing RecyclerView inflated items
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

fun RecyclerView.lastViewPosition(): Int {
    val position = (layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
    return if (position < 0) 0 else position
}


