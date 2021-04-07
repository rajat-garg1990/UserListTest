package com.application.userlisttest.retro

data class User(var data: ArrayList<UserResponse>)

data class UserResponse (
var id: Int,
var email: String,
var first_name: String,
var last_name: String,
var avatar: String
)
