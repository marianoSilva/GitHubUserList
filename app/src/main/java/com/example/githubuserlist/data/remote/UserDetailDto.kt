package com.example.githubuserlist.data.remote


import com.google.gson.annotations.SerializedName

data class UserDetailDto(
    @SerializedName("email")
    val email: Any,
    @SerializedName("events_url")
    val eventsUrl: String,
    @SerializedName("followers")
    val followers: Int,
    @SerializedName("location")
    val location: String,
    @SerializedName("login")
    val login: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("public_repos")
    val publicRepos: Int
)