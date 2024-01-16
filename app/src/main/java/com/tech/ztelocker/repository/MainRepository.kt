package com.tech.ztelocker.repository

import com.tech.ztelocker.api.ApiHelper
import com.example.ztelocker.model.Retailer
import com.example.ztelocker.model.RetailerResponse
import com.example.ztelocker.model.UserMobileRegistration
import com.tech.ztelocker.model.QRCodeCreateRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    fun setUserMobileRegistration(userMobileRegistration: UserMobileRegistration){
        apiHelper.setMobileRegistrationData(userMobileRegistration)
    }
    suspend fun setLogin(retailer: Retailer):Flow<RetailerResponse> {
       return apiHelper.checkLogin(retailer)
    }
    suspend fun createRegisterQRCode(request: QRCodeCreateRequest): Flow<String> =
        apiHelper.createRegisterQRCode(request)
}