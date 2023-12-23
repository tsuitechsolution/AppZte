package com.example.ztelocker.ui.activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.tech.ztelocker.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
        private val rvSubject: RecyclerView? = null
        private var subjectAdapter: RecyclerViewAdapter? = null
        private var subjects: Subject? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
        }


    override fun onRestart() {
        super.onRestart()
        Log.d("onRestart","hii")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroy","hii")

    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause","hii")

    }

    override fun onStop() {
        super.onStop()
        Log.d("onStop","hii")

    }

    override fun onStart() {
        super.onStart()
        Log.d("onStart","hii")

    }

    override fun onResume() {
        super.onResume()
        Log.d("resume","hii")

    }

    fun prepareData(): Subject {

        return Subject("Balance", R.drawable.baseline_vpn_key_24)
    }
}