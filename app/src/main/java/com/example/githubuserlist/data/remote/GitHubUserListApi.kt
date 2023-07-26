package com.example.githubuserlist.data.remote

import retrofit2.http.GET

interface GitHubUserListApi {

    @GET("users")
    suspend fun getUserData() : UserDtoList
}