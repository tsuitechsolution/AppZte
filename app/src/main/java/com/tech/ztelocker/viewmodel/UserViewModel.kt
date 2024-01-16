package com.example.ztelocker.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ztelocker.model.UserMobileRegistration
import com.tech.ztelocker.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(val mainRepository: MainRepository
): ViewModel() {
    fun setData(userMobileRegistration: UserMobileRegistration){
       mainRepository.setUserMobileRegistration(userMobileRegistration)
    }
}