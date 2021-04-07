package com.application.userlisttest.retro

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users?page=2")
    fun getUsers() :Call<User>
}