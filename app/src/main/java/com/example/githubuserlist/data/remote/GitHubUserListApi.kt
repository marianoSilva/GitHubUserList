package com.example.githubuserlist.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubUserListApi {
    @GET("users")
    suspend fun getUserData() : UserDtoList

    @GET("users/{url}")
    suspend fun getDetailData(@Path(value = "url", encoded = true) url : String) : UserDetailDto

    @GET("users/{url}/repos")
    suspend fun getRepositoryData(@Path(value = "url", encoded = true) url : String) : RepositoryDtoList
}