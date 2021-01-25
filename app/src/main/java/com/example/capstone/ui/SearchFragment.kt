package com.example.capstone.ui

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.capstone.R
import com.example.capstone.databinding.FragmentHomeBinding
import com.example.capstone.databinding.FragmentProfileBinding
import com.example.capstone.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private var layout: View? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        when (arguments?.getString(ARG_LAYOUT)) {
            "Home" -> {
                layout = layoutInflater.inflate(R.layout.fragment_home, container, false)
            }

            "Profile" -> {
                layout = layoutInflater.inflate(R.layout.fragment_profile, container, false)
            }
        }

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchPopup()
    }

    private fun searchPopup() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle(R.string.tv_platform)
        val dialogLayout = layoutInflater.inflate(R.layout.search_popup, null)

        builder.setView(dialogLayout)
        builder.show()
    }


}