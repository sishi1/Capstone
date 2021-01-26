package com.example.capstone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.capstone.R
import com.example.capstone.databinding.FragmentProfileBinding
import com.google.android.material.tabs.TabLayout


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

//    private fun configureTabLayout() {
//        tabLayout.addTab(tabLayout.newTab().setText("Overview"))
//        tabLayout.addTab(tabLayout.newTab().setText("Legends"))
//        tabLayout.addTab(tabLayout.newTab().setText("Recent Matches"))
//
//        val tabAdapter = TabPagerAdapter(childFragmentManager, tabLayout.tabCount)
//        binding.viewPager.adapter = tabAdapter
//
//        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
//
//        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                binding.viewPager.currentItem = tab!!.position
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//
//            }
//        })
//    }

}