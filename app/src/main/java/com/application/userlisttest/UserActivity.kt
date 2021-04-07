package com.application.userlisttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.userlisttest.adapters.UserRecyclerAdapter
import com.application.userlisttest.mvvm.UserViewModel

class UserActivity : AppCompatActivity() {
    lateinit var userViewModel: UserViewModel
    lateinit var rAdapter: UserRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        var recycler=findViewById<RecyclerView>(R.id.userRecycler)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.getUsers()
        userViewModel.users.observe(this, Observer {
            rAdapter.getUsers(it.data)
        })
        rAdapter=UserRecyclerAdapter(this)
        recycler.apply {
            adapter=rAdapter
            layoutManager=LinearLayoutManager(this@UserActivity)
        }
    }
}