package com.tech.ztelocker.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import com.example.ztelocker.util.Status
import com.example.ztelocker.viewmodel.LoginViewModel
import com.squareup.picasso.Picasso
import com.tech.ztelocker.R
import com.tech.ztelocker.databinding.ActivityScanBinding

class ScanActivity : AppCompatActivity() {
    lateinit var binding:ActivityScanBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val backBtn=findViewById<ImageView>(R.id.ivBack)
        backBtn.setOnClickListener {
            onBackPressed()
        }
        viewModel.getQRCodeImage("smart-locker")
        viewModel.qrCodeImage.observe(this){
            when (it.status) {
                Status.SUCCESS -> {
                    binding.loading.visibility = View.GONE
                    it.data?.let { data ->
                        binding.qrImg.setOnClickListener {
                            if (savedInstanceState == null) {

                                Picasso.get()
                                    .load("http://emmapi.ablsoln.in/EMMApplication/tokenURL/LPUWOCNUSMBPVGCLITBF")
                                    .placeholder(R.drawable.baseline_image_24)
                                    .error(R.drawable.error_image)
                                    .into(binding.qrImg)
                            }

                        }

                    }
                }

                Status.LOADING -> {
                    binding.loading.visibility = View.VISIBLE
                }

                Status.ERROR -> {
                    //Handle Error
                    binding.loading.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }

                else -> {}
            }
        }
    }
    }
}