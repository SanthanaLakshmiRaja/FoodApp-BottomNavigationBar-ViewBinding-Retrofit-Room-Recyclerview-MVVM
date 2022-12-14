package com.example.foodapp.ui.activity


import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodapp.R
import com.example.foodapp.databinding.ActivityMainBinding





class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView: BottomNavigationView = binding.mBottomNavigationView
        val navController = findNavController(R.id.mNavController)
       // By calling this method, the title in the action bar will automatically be updated when the destination change
        val appBarConfiguration=AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_favorite, R.id.navigation_category))
        setupActionBarWithNavController(navController, appBarConfiguration)
        //The selected item in the NavigationView will automatically be updated when the destination changes.
        bottomNavigationView.setupWithNavController(navController)


    }

}