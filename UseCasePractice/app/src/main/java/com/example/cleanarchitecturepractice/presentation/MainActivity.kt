package com.example.cleanarchitecturepractice.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecturepractice.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // use Koin extension function for creating ViewModel. Invocation will find rule for creating ViewModel in Koin modules
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Log.e("MainActivity", "Activity created")

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