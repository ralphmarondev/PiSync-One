package com.ralphmarondev.pisync_one.user.dto

data class RegisterRequest(
    val fullName: String,
    val email: String,
    val password: String
)