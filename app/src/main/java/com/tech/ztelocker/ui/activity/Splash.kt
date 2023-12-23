package com.example.ztelocker.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tech.ztelocker.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("onRestart","hiiSplash")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroy","hiiSplash")

    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause","hiiSplash")

    }

    override fun onStop() {
        super.onStop()
        Log.d("onStop","hiiSplash")

    }

    override fun onStart() {
        super.onStart()
        Log.d("onStart","hiiSplash")

    }

    override fun onResume() {
        super.onResume()
        Log.d("resume","hiiSplash")

    }
}