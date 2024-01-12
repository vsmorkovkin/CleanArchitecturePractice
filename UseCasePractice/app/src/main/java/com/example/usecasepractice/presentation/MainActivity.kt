package com.example.usecasepractice.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.usecasepractice.databinding.ActivityMainBinding
import com.example.usecasepractice.domain.models.SaveUserNameParam
import com.example.usecasepractice.domain.usercase.GetUserNameUseCase
import com.example.usecasepractice.domain.usercase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // set save data button onClick
        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString() // get text from editText
            val params = SaveUserNameParam(name = text) // create params for usercase.execute()
            val result = saveUserNameUseCase.execute(param = params) // execute usercase and save result
            binding.dataTextView.text = "Save result = $result" // print result in textView
        }

        // set get data button onCling
        binding.receiveDataButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            binding.dataTextView.text = "${userName.firstName} ${userName.lastName}" // print userName in textView
        }
    }
}