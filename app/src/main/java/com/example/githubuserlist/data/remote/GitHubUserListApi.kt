package com.example.githubuserlist.data.remote

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface GitHubUserListApi {
    @Headers("Authorization: Bearer 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")
    @GET("users")
    suspend fun getUserData() : UserDtoList

    @Headers("Authorization: Bearer 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")
    @GET("users/{url}")
    suspend fun getDetailData(@Path(value = "url", encoded = true) url : String) : UserDetailDto

    @Headers("Authorization: Bearer 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")
    @GET("users/{url}/repos")
    suspend fun getRepositoryData(@Path(value = "url", encoded = true) url : String) : RepositoryDtoList
}