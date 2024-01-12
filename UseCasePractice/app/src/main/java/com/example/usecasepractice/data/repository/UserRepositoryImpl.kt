package com.example.usecasepractice.data.repository

import android.content.Context
import com.example.usecasepractice.domain.models.SaveUserNameParam
import com.example.usecasepractice.domain.models.UserName
import com.example.usecasepractice.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "SHARED_PREFS_NAME"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_FIRST_NAME = "Default first name"
private const val DEFAULT_LAST_NAME = "Default last name"

class UserRepositoryImpl(context: Context) : UserRepository {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        sharedPreferences
            .edit()
            .putString(KEY_FIRST_NAME, saveParam.name)
            .apply()

        return true
    }

    override fun getName(): UserName {
        val firstName =
            sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_FIRST_NAME
        val lastName =
            sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME

        return UserName(firstName = firstName, lastName = lastName)
    }
}