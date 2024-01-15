package com.example.cleanarchitecturepractice.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecturepractice.data.repository.UserRepositoryImpl
import com.example.cleanarchitecturepractice.data.storage.sharedprefs.SharedPrefsUserStorage
import com.example.cleanarchitecturepractice.databinding.ActivityMainBinding
import com.example.cleanarchitecturepractice.domain.usercase.GetUserNameUseCase
import com.example.cleanarchitecturepractice.domain.usercase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // by lazy - initialize when instances are needed (first call)
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(SharedPrefsUserStorage(applicationContext))
    }

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository = userRepository)
    }

    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository = userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // set save data button onClick
        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString() // get text from editText
            val params =
                com.example.cleanarchitecturepractice.domain.models.SaveUserNameParam(name = text) // create params for usercase.execute()
            val result =
                saveUserNameUseCase.execute(param = params) // execute usercase and save result
            binding.dataTextView.text = "Save result = $result" // print result in textView
        }

        // set get data button onCling
        binding.receiveDataButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            binding.dataTextView.text =
                "${userName.firstName} ${userName.lastName}" // print userName in textView
        }
    }
}