package com.example.capstone.ui.fragments.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.capstone.ui.fragments.LegendsFragment
import com.example.capstone.ui.fragments.MatchesFragment
import com.example.capstone.ui.fragments.OverviewFragment

@Suppress("DEPRECATION")
class TabPagerAdapter(fm: FragmentManager, private var tabCount: Int) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> OverviewFragment()
            1 -> LegendsFragment()
            2 -> MatchesFragment()
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}