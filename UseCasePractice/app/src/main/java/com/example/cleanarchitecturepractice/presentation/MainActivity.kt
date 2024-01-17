package com.example.cleanarchitecturepractice.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturepractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Log.e("MainActivity", "Activity created")

        viewModel = ViewModelProvider(this, MainViewModelFactory(applicationContext))
            .get(MainViewModel::class.java)

        viewModel.resultLive.observe(this) { text ->
            binding.dataTextView.text = text
        }

        // set SaveDataButton onClick
        binding.sendButton.setOnClickListener {
            val userName = binding.dataEditText.text.toString()
            viewModel.save(userName)
        }

        // set get data button onCling
        binding.receiveDataButton.setOnClickListener {
            viewModel.load()
        }
    }

    override fun onPause() {
        Log.e("MainActivity", "Activity paused")
        super.onPause()
    }

    override fun onStop() {
        Log.e("MainActivity", "Activity stopped")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e("MainActivity", "Activity destroyed")
        super.onDestroy()


    }
}