package com.talhaoz.viewbinding_use_with_basefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.talhaoz.viewbinding_use_with_basefragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var navController: NavController? = null
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.fragNavHost)

    }
}