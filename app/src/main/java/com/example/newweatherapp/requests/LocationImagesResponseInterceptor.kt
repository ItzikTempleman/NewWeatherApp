package com.example.newweatherapp.requests

import com.example.newweatherapp.utils.Constants
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class LocationImagesResponseInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request().newBuilder()
            .addHeader("x-rapidapi-key", Constants.API_KEY)
            .addHeader("x-rapidapi-host", Constants.LOCATION_IMAGES_API_HOST)
            .build()
        return chain.proceed(request)
    }
}