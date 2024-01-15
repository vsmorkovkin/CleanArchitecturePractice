package com.example.cleanarchitecturepractice.data.repository

import com.example.cleanarchitecturepractice.data.storage.UserStorage
import com.example.cleanarchitecturepractice.data.storage.models.User
import com.example.cleanarchitecturepractice.domain.models.SaveUserNameParam
import com.example.cleanarchitecturepractice.domain.models.UserName
import com.example.cleanarchitecturepractice.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)

        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()

        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(
            firstName = saveParam.name,
            lastName = "some_last_name"
        )
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(
            firstName = user.firstName,
            lastName = user.lastName
        )
    }
}