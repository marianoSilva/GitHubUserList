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