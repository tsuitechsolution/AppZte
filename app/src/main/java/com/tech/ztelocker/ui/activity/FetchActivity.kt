package com.tech.ztelocker.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.tech.ztelocker.R

class FetchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch)
        val backBtn=findViewById<ImageView>(R.id.ivBack)
        backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}