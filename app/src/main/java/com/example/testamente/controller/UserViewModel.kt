package com.example.testamente.controller

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.testamente.model.AppDatabase
import com.example.testamente.model.User
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao = AppDatabase.getDatabase(application).userDao()

    fun registerUser(user: User) {
        viewModelScope.launch {
            userDao.insert(user)
        }
    }

    fun loginUser(username: String, password: String, callback: (User?) -> Unit) {
        viewModelScope.launch {
            val user = userDao.login(username, password)
            callback(user)
        }
    }
}
