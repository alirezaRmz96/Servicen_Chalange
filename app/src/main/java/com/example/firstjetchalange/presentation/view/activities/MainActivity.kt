package com.example.firstjetchalange.presentation.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.firstjetchalange.R
import com.example.firstjetchalange.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding :ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        navController = findNavController(R.id.nav_host_fragment)

        setupActionBarWithNavController(navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,null)
    }
}