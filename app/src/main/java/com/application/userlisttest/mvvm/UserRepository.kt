package com.application.userlisttest.mvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.application.userlisttest.retro.ApiService
import com.application.userlisttest.retro.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRepository() {
    private var base_url="https://reqres.in/api/"
    var users=MutableLiveData<User>()
    private val retro=Retrofit.Builder()
        .baseUrl(base_url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var service=retro.create(ApiService::class.java)

    fun getUsers(){
        service.getUsers().enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                users.value=response.body()
                Log.d("all", "success")
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("all", t.message.toString())
            }
        })
    }
}