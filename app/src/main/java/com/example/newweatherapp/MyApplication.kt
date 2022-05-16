package com.example.newweatherapp

import android.app.Application
import android.content.Context


class MyApplication: Application() {

    companion object {
        private var INSTANCE: MyApplication? = null

        fun getInstance() : Context {
            return INSTANCE!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}