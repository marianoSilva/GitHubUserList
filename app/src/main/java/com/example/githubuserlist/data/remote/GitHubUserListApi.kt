package com.example.githubuserlist.data.remote

import retrofit2.http.GET
import retrofit2.http.Headers

interface GitHubUserListApi {

    @Headers("Authorization: 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")
    @GET("users")
    suspend fun getUserData() : UserDtoList
}