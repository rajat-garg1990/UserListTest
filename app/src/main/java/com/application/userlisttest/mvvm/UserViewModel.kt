package com.application.userlisttest.mvvm

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.application.userlisttest.retro.User

class UserViewModel() : ViewModel() {
    var userRepository = UserRepository()
    var users: LiveData<User> = userRepository.users

    fun getUsers(){
        userRepository.getUsers()
    }
}