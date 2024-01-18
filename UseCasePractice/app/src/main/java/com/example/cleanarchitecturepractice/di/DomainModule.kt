package com.example.cleanarchitecturepractice.di

import com.example.cleanarchitecturepractice.domain.usercase.GetUserNameUseCase
import com.example.cleanarchitecturepractice.domain.usercase.SaveUserNameUseCase
import org.koin.dsl.module


val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

}