package com.example.cleanarchitecturepractice.di

import com.example.cleanarchitecturepractice.data.repository.UserRepositoryImpl
import com.example.cleanarchitecturepractice.data.storage.UserStorage
import com.example.cleanarchitecturepractice.data.storage.sharedprefs.SharedPrefsUserStorage
import com.example.cleanarchitecturepractice.domain.repository.UserRepository
import org.koin.dsl.module


val dataModule = module {

    single<UserStorage> {
        SharedPrefsUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}