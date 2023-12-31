package com.example.githubuserlist.presentation.user

import com.example.githubuserlist.data.remote.domain.user.UserList

data class UserState(
    val userList: UserList? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
