package com.example.listedassignment


import android.content.res.ColorStateList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentTransaction
import com.example.listedassignment.Fragment.LinkFragment
import com.example.listedassignment.Utiles.SessionManager
import com.example.listedassignment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val color = ContextCompat.getColor(this, R.color.white)
        binding.fab.imageTintList = ColorStateList.valueOf(color)
        binding.bottomNavView.background = null
        binding.bottomNavView.itemIconTintList = null

    }
}