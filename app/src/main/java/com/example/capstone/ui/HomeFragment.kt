package com.example.capstone.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.capstone.databinding.FragmentHomeBinding
import androidx.browser.customtabs.CustomTabsIntent


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cvNews.setOnClickListener { portalCardClicked("https://www.ea.com/games/apex-legends/news?isLocalized=true") }
        binding.cvStatus.setOnClickListener { portalCardClicked("https://apexlegendsstatus.com/") }
        binding.cvTwitter.setOnClickListener { portalCardClicked("https://twitter.com/PlayApex") }
        binding.cvTwitch.setOnClickListener { portalCardClicked("https://www.twitch.tv/playapex") }

    }

    private fun portalCardClicked(link: String) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()

        customTabsIntent.launchUrl(this.requireContext(), Uri.parse(link))
    }
}
