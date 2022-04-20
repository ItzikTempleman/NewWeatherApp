package com.example.newweatherapp.requests

import com.example.newweatherapp.utils.Constants.API_HOST
import com.example.newweatherapp.utils.Constants.API_KEY
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request().newBuilder()
            .addHeader("x-rapidapi-key", API_KEY)
            .addHeader("x-rapidapi-host", API_HOST)
            .build()
        return chain.proceed(request)
    }
}