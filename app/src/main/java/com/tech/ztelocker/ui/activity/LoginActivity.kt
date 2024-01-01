package com.example.ztelocker.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.ztelocker.viewmodel.LoginViewModel
import com.tech.ztelocker.databinding.ActivityLoginBinding
import com.tech.ztelocker.ui.activity.MainActivity

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onCliclistner()
    }

    private fun onCliclistner() {
        val btnSubmit=binding.loginBtnSignin
        //TODO("Not yet implemented")
        val userEmailOrMobile=binding.etEmailLogin.text
        val password=binding.etPasswordLogin.text
       btnSubmit.setOnClickListener {
       startActivity(Intent(this, MainActivity::class.java))
       }
    }
}