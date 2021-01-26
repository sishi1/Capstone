package com.example.capstone.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.capstone.R
import com.example.capstone.databinding.FragmentMatchesBinding


class MatchesFragment : Fragment() {

    private lateinit var binding: FragmentMatchesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchesBinding.inflate(layoutInflater)
        return binding.root
    }

}