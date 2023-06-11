package com.odenizturker.auth.model

data class UserModel(
    val id: Long,
    val firstName: String,
    val secondName: String,
    val username: String,
    val emailAddress: String
)
