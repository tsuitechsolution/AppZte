package com.example.ztelocker.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tech.ztelocker.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("onRestart","hiiprof")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroy","hiiprof")

    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause","hiiprof")

    }

    override fun onStop() {
        super.onStop()
        Log.d("onStop","hiiprof")

    }

    override fun onStart() {
        super.onStart()
        Log.d("onStart","hiiprof")

    }

    override fun onResume() {
        super.onResume()
        Log.d("resume","hiiprof")

    }
}