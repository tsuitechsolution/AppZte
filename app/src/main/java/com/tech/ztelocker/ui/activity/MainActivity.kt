package com.tech.ztelocker.ui.activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.ztelocker.ui.activity.AddCustomerActivity
import com.example.ztelocker.ui.activity.CustomerListActivity
import com.example.ztelocker.ui.activity.RecyclerViewAdapter
import com.example.ztelocker.ui.activity.Subject
import com.example.ztelocker.ui.activity.TopUpHistorActivityy
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tech.ztelocker.R
import com.tech.ztelocker.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
        private val rvSubject: RecyclerView? = null
        private var subjectAdapter: RecyclerViewAdapter? = null
        private var subjects: Subject? = null
        var binding:ActivityMainBinding?= null
    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding= ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding!!.root)
           bottomNavigationView= binding!!.bottomNav
            val host: NavHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return
            navController = host.navController


    bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.homegragment -> {
                   navController.navigate(R.id.homegragment)
                  it.isChecked = true
              }

               R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment)
                    it.isChecked = true
               }
               R.id.logout_fragment -> {
                    navController.navigate(
                        R.id.logout_fragment,
                       bundleOf("isUsed" to "1"))
                     it.isChecked = true
                 }
            }
            false
        }
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