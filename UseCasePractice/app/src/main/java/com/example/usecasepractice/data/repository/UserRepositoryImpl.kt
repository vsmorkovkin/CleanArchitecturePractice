package com.example.usecasepractice.data.repository

import com.example.usecasepractice.data.storage.UserStorage
import com.example.usecasepractice.data.storage.models.User
import com.example.usecasepractice.domain.models.SaveUserNameParam
import com.example.usecasepractice.domain.models.UserName
import com.example.usecasepractice.domain.repository.UserRepository


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