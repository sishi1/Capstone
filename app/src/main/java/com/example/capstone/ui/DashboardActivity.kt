package com.example.capstone.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.capstone.R
import com.example.capstone.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    enum class HOMEPAGE_NAVIGATION_DESTINATION {
        SEARCH,
        HOME,
        PROFILE
    }

    private lateinit var navController: NavController
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        binding.bottomNav.selectedItemId = R.id.page_home
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.dashboard_nav_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNav.setOnNavigationItemSelectedListener { bottomNavigationClickHandler(it) }
    }

    private fun bottomNavigationClickHandler(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.page_search -> {
                handleNavigation(HOMEPAGE_NAVIGATION_DESTINATION.SEARCH)
                true
            }
            R.id.page_home -> {
                handleNavigation(HOMEPAGE_NAVIGATION_DESTINATION.HOME)
                true
            }
            R.id.page_profile -> {
                handleNavigation(HOMEPAGE_NAVIGATION_DESTINATION.PROFILE)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    /**
     * Handles the navigation
     * @param destination HOMEPAGE_NAVIGATION_DESTINATION
     */
    private fun handleNavigation(destination: HOMEPAGE_NAVIGATION_DESTINATION) {
        val currentLocation = navController.currentDestination?.label

        when (destination) {

            HOMEPAGE_NAVIGATION_DESTINATION.SEARCH -> {
                when (currentLocation) {
                    "fragment_home" -> {
                        navController.navigate(R.id.action_homeFragment_to_searchFragment)
                    }

                    "fragment_profile" -> {
                        navController.navigate(R.id.action_profileFragment_to_searchFragment)
                    }
                }
            }

            HOMEPAGE_NAVIGATION_DESTINATION.HOME -> {
                when (currentLocation) {
                    "fragment_search" -> {
                        navController.navigate(R.id.action_searchFragment_to_homeFragment)
                    }

                    "fragment_profile" -> {
                        navController.navigate(R.id.action_profileFragment_to_homeFragment)
                    }
                }
            }

            HOMEPAGE_NAVIGATION_DESTINATION.PROFILE -> {
                when (currentLocation) {
                    "fragment_search" -> {
                        navController.navigate(R.id.action_searchFragment_to_profileFragment)
                    }

                    "fragment_home" -> {
                        navController.navigate(R.id.action_homeFragment_to_profileFragment)
                    }
                }
            }
        }
    }
}