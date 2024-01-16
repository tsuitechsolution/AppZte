package com.tech.ztelocker.api

import com.example.ztelocker.model.Retailer
import com.example.ztelocker.model.RetailerResponse
import com.example.ztelocker.model.UserMobileRegistration
import com.example.ztelocker.network.RetrofitInstance
import com.tech.ztelocker.model.QRCodeCreateRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApiHelperImp @Inject constructor(): ApiHelper {
    override fun setMobileRegistrationData(userMobileRegistration: UserMobileRegistration) {
        RetrofitInstance.getRetrofitInstance()?.setUserMobileRegistration(userMobileRegistration)

    }
    override suspend fun createRegisterQRCode(request: QRCodeCreateRequest): Flow<String> {
        return flow {
            RetrofitInstance.getRetrofitInstance()?.let { emit(it.createRegisterQRCode(request)) }
        }
    }

    override suspend fun checkLogin(retailer: Retailer): Flow<RetailerResponse> {

        return flow {
            RetrofitInstance.getRetrofitInstance()?.checkLogin(retailer)?.let { emit(it) }
        }
    }
}