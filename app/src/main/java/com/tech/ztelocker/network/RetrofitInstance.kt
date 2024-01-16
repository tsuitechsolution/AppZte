package com.example.ztelocker.network

import com.tech.ztelocker.api.ApiiServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
  companion object{
      var retrofit: Retrofit? = null
      private const val BASE_URL =
          "http://192.168.29.192.168.29.248:8080/Ztelockers/"
      private var newApi: ApiiServices? = null
      fun getRetrofitInstance(): ApiiServices? {
      retrofit =Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
          newApi= retrofit?.create(ApiiServices::class.java)
          return newApi
      }
  }
}