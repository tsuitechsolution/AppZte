package com.tech.ztelocker.api

import com.example.ztelocker.model.Retailer
import com.example.ztelocker.model.RetailerResponse
import com.example.ztelocker.model.UserMobileRegistration
import com.tech.ztelocker.model.QRCodeCreateRequest
import kotlinx.coroutines.flow.Flow

interface ApiHelper {
    fun setMobileRegistrationData(userMobileRegistration: UserMobileRegistration)
     suspend fun checkLogin(retailer: Retailer): Flow<RetailerResponse>
    suspend fun createRegisterQRCode(request: QRCodeCreateRequest): Flow<String>

}