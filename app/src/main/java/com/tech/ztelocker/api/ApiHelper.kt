package com.example.ztelocker.api

import com.example.ztelocker.model.Retailer
import com.example.ztelocker.model.RetailerResponse
import com.example.ztelocker.model.UserMobileRegistration
import kotlinx.coroutines.flow.Flow

interface ApiHelper {
    fun setMobileRegistrationData(userMobileRegistration: UserMobileRegistration)
     suspend fun checkLogin(retailer: Retailer): Flow<RetailerResponse>
}