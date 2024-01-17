package com.example.cleanarchitecturepractice.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturepractice.domain.models.SaveUserNameParam
import com.example.cleanarchitecturepractice.domain.models.UserName
import com.example.cleanarchitecturepractice.domain.usercase.GetUserNameUseCase
import com.example.cleanarchitecturepractice.domain.usercase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val _resultLive = MutableLiveData<String>()
    val resultLive: LiveData<String>
        get() = _resultLive

    init {
        Log.e("MainActivityVM", "VM created")
    }

    override fun onCleared() {
        Log.e("MainActivityVM", "VM cleared")
        super.onCleared()
    }


    fun save(userName: String) {
        val useCaseParameter = SaveUserNameParam(name = userName) // create params for usercase.execute()
        val resultData = saveUserNameUseCase.execute(param = useCaseParameter) // execute usercase and save result
        _resultLive.value = "Save result = $resultData" // print result in textView
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        _resultLive.value = "${userName.firstName} ${userName.lastName}"
    }

}