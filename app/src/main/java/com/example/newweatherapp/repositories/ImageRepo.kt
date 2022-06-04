package com.example.newweatherapp.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.newweatherapp.models.location_images.ImagesResponse
import com.example.newweatherapp.requests.Requests
import com.example.newweatherapp.requests.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ImageRepo {
    private val dataRequest: Requests = RetrofitInstance.getLocationImageRetrofit().create(Requests::class.java)

    fun getInstance(): ImageRepo {
        return this
    }

    fun getImages(cityName: String): MutableLiveData<ImagesResponse> {
        val imagesLiveData: MutableLiveData<ImagesResponse> = MutableLiveData()
        dataRequest.getImages(cityName).enqueue(object : Callback<ImagesResponse> {
            override fun onResponse(call: Call<ImagesResponse>, response: Response<ImagesResponse>) {
                if (response.isSuccessful) {
                    val imageResponse = response.body()
                    imageResponse.let {
                        imagesLiveData.value = it
                    }
                }else  Log.d("WOW", "onResponse: having some issues ${response.errorBody()}")
               // Log.d("WOW", "response body: "+response.code())
            }

            override fun onFailure(call: Call<ImagesResponse>, t: Throwable) {
                Log.e("WOW", t.message.toString())
            }

        })
        return imagesLiveData
    }

}