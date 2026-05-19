package io.aristiyo.capstone.screen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.dynamicfeatures.fragment.DynamicNavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import io.aristiyo.capstone.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(binding.navigationHostFragment.id) as DynamicNavHostFragment
        val navController = navHostFragment.navController
        binding.homeBottomNavigation.setupWithNavController(navController)
    }
}