package com.silverorange.videoplayer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.silverorange.videoplayer.R
import com.silverorange.videoplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

}