package com.example.githubuserlist.data.remote.domain.repository

import com.example.githubuserlist.data.remote.domain.user.UserList
import com.example.githubuserlist.data.remote.domain.util.Resource


interface UserRepository {

    suspend fun getUser() : Resource<UserList>
}