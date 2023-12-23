package com.example.ztelocker.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.ztelocker.model.UserMobileRegistration
import com.example.ztelocker.viewmodel.UserViewModel
import com.tech.ztelocker.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddCustomerActivity: AppCompatActivity() {
    //private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_customer)
        val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val submit=findViewById<Button>(R.id.btn_submit)
        submit.setOnClickListener{
            val name=findViewById<EditText>(R.id.eT_userEmail).text.toString()
            val email=findViewById<EditText>(R.id.eT_userEmail).text.toString()
            val mobile=findViewById<EditText>(R.id.eT_userMobile).text.toString()


            val imei1=findViewById<EditText>(R.id.eT_userImei1).text.toString()
            val imei2=findViewById<EditText>(R.id.eT_userImei2).text.toString()
            val userMobileRegistration=UserMobileRegistration(name,email,mobile ,imei1,imei2)
            userViewModel.setData(userMobileRegistration)
        }
    }
}