package com.example.ztelocker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ztelocker.model.Retailer
import com.example.ztelocker.model.RetailerResponse
import com.tech.ztelocker.repository.MainRepository
import com.example.ztelocker.util.NetworkHelper
import com.example.ztelocker.util.Resource
import com.tech.ztelocker.model.QRCodeCreateRequest
import com.tech.ztelocker.util.isValidHttpAddress
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val mainRepository: MainRepository,
                                         private val networkHelper: NetworkHelper,
                                ): ViewModel() {
    private val _users = MutableLiveData<Resource<RetailerResponse>>()
    val users: LiveData<Resource<RetailerResponse>>
        get() = _users
    private val _QRCodeImage = MutableLiveData<Resource<String>>()
    val qrCodeImage: LiveData<Resource<String>>
        get() = _QRCodeImage


    fun setLogin(email:String,password:String){
        val loginRequest=Retailer(email,password)
        validateLoginData(loginRequest)

    }
    private fun validateLoginData(loginRequest: Retailer) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _users.postValue(Resource.loading(null))
                if (networkHelper.isNetworkConnected()) {
                    mainRepository.setLogin(loginRequest).collect { results ->
                        if (results.status) {
                            _users.postValue(Resource.success(results))
                        } else _users.postValue(Resource.error(results.msg, null))
                    }
                } else _users.postValue(Resource.error("No internet connection", null))
            } catch (e: Exception) {
                e.printStackTrace()
                _users.postValue(Resource.error(e.message.toString(), null))
            }
        }
    }
    fun getQRCodeImage(key:String) {
        val qrCodeCreateRequest = QRCodeCreateRequest(
            data = key
        )
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _QRCodeImage.postValue(Resource.loading(null))
                if (networkHelper.isNetworkConnected()) {
                    mainRepository.createRegisterQRCode(qrCodeCreateRequest).collect {
                        if (it.isValidHttpAddress()) {
                            _QRCodeImage.postValue(Resource.success(it))
                        } else _QRCodeImage.postValue(Resource.error(it, null))
                    }
                } else _QRCodeImage.postValue(Resource.error("No internet connection", null))
            } catch (e: Exception) {
                e.printStackTrace()
                _QRCodeImage.postValue(Resource.error(e.message.toString(), null))
            }
        }
    }
}