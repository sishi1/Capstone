package com.example.capstone.ui

import android.app.AlertDialog
import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.capstone.databinding.FragmentHomeBinding
import androidx.browser.customtabs.CustomTabsIntent
import com.example.capstone.R


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val alNews: String = "https://www.ea.com/games/apex-legends/news?isLocalized=true"
    private val alStatus: String = "https://apexlegendsstatus.com/"
    private val alTwitter: String = "https://twitter.com/PlayApex"
    private val alTwitch: String = "https://www.twitch.tv/playapex"

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cvNews.setOnClickListener { showConfirmationDialog(alNews) }
        binding.cvStatus.setOnClickListener { showConfirmationDialog(alStatus) }
        binding.cvTwitter.setOnClickListener { showConfirmationDialog(alTwitter) }
        binding.cvTwitch.setOnClickListener { showConfirmationDialog(alTwitch) }



    }

    private fun portalCardClicked(link: String) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()

        customTabsIntent.launchUrl(this.requireContext(), Uri.parse(link))
    }

    private fun showConfirmationDialog(link: String) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Are you sure?")
        val dialogLayout = layoutInflater.inflate(R.layout.open_link_dialog, null)

        builder.setView(dialogLayout)
        builder.setPositiveButton(R.string.confirmation_yes) {_: DialogInterface, _: Int ->
            portalCardClicked(link)
        }
        builder.setNegativeButton(R.string.confirmation_no) {_: DialogInterface, _: Int ->
            returnTransition
        }
        builder.show()
    }
}
