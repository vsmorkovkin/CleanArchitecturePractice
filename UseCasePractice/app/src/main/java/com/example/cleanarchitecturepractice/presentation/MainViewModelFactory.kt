package com.example.cleanarchitecturepractice.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturepractice.data.repository.UserRepositoryImpl
import com.example.cleanarchitecturepractice.data.storage.sharedprefs.SharedPrefsUserStorage
import com.example.cleanarchitecturepractice.domain.usercase.GetUserNameUseCase
import com.example.cleanarchitecturepractice.domain.usercase.SaveUserNameUseCase

class MainViewModelFactory(applicationContext: Context) : ViewModelProvider.Factory {

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

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}