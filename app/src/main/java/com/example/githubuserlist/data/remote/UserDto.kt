package com.example.githubuserlist.data.remote


import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("login")
    val login: String,
    @SerializedName("repos_url")
    val reposUrl: String,
    @SerializedName("url")
    val url: String
)