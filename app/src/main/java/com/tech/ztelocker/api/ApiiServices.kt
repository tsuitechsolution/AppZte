package com.tech.ztelocker.api

import com.example.ztelocker.model.Retailer
import com.example.ztelocker.model.RetailerResponse
import com.example.ztelocker.model.UserMobileRegistration
import com.example.ztelocker.model.UserMobileRegistrationResponse
import com.tech.ztelocker.model.QRCodeCreateRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiiServices {
    @POST("/userRegistration/")
    fun setUserMobileRegistration(@Body userMobileRegistration: UserMobileRegistration): UserMobileRegistrationResponse
    @POST("/loginRetailer")
   suspend fun checkLogin(@Body retailer: Retailer): RetailerResponse
    @POST("createRegisterQRCode")
    suspend fun createRegisterQRCode(
        @Body request: QRCodeCreateRequest
    ): String
  }