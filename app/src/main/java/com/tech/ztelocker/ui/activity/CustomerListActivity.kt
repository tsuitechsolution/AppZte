package com.example.ztelocker.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.tech.ztelocker.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_list)
        val backBtn=findViewById<ImageView>(R.id.ivBack)
        backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}