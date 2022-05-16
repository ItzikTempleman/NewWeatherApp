package com.example.newweatherapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newweatherapp.R
import com.example.newweatherapp.databinding.ActivityMainBinding
import com.example.newweatherapp.utils.Constants
import com.google.android.libraries.places.api.Places

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}
