package com.tech.ztelocker.ui.activity

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.example.ztelocker.ui.activity.AddCustomerActivity
import com.example.ztelocker.ui.activity.CustomerListActivity
import com.example.ztelocker.ui.activity.TopUpHistorActivityy
import com.permissionx.guolindev.PermissionX
import com.tech.ztelocker.R
import com.tech.ztelocker.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentHomeBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

        // Inflate the layout for this fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val scan= binding.linear1
        val  list= binding.linear2
        val addBtn= binding.linear3
        val history= binding!!.linear4
        val supportBtn= binding!!.linear5
        val  policyBtn= binding!!.linear6
        val  fetchBtn= binding!!.linear7
        val btn8= binding!!.linear8


        scan.setOnClickListener {
            startActivity(Intent(requireContext(), ScanActivity::class.java))

        }
        list.setOnClickListener {
            startActivity(Intent(requireContext(), CustomerListActivity::class.java))

        }
        addBtn.setOnClickListener {
            startActivity(Intent(requireContext(), AddCustomerActivity::class.java))

        }
        history.setOnClickListener {
            startActivity(Intent(requireContext(), TopUpHistorActivityy::class.java))

        }
        supportBtn.setOnClickListener {
            val popupMenu = PopupMenu(requireContext(), it)
            popupMenu.menuInflater.inflate(R.menu.support_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.call_support -> {
                        PermissionX.init(requireActivity())
                            .permissions(Manifest.permission.CALL_PHONE)

                            .request { allGranted, grantedList, deniedList ->
                                if (allGranted) {
                                    val callIntent = Intent(Intent.ACTION_CALL)
                                    callIntent.data =
                                        Uri.parse("tel:${919330987985}")
                                    startActivity(callIntent)
                                } else {
                                    val intent = Intent(
                                        Intent.ACTION_DIAL,
                                        Uri.fromParts(
                                            "tel",
                                            919330987985.toString(),
                                            null
                                        )
                                    )
                                    startActivity(intent)
                                }
                            }
                    }
                    R.id.email_support -> {
                        val intent = Intent(Intent.ACTION_SENDTO)
                        intent.data =
                            Uri.parse("mailto:tsuitechsolution@gmail.com") // only email apps should handle this
                        intent.putExtra(Intent.EXTRA_EMAIL, "tsuitechsolution@gmail.com")
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Support Request")
                        try {
                            startActivity(intent)
                        } catch (e: Exception) {
                            Toast.makeText(
                                context,
                                e.localizedMessage,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

                }
                true
            }
            popupMenu.show()

        }
        policyBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.tsuitechsolution.com/privacy-policy/\n" +
                    "\n")
            startActivity(intent)
        }
        fetchBtn.setOnClickListener {
            startActivity(Intent(requireContext(), FetchActivity::class.java))

        }
        btn8.setOnClickListener{
            startActivity(Intent(requireContext(), FetchActivity::class.java))

        }
    }


}