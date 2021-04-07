package com.application.userlisttest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.application.userlisttest.mvvm.UserViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fetchButton = findViewById<Button>(R.id.fetchButton)
        fetchButton.setOnClickListener {
            startActivity(Intent(this,UserActivity::class.java))
        }
    }
}