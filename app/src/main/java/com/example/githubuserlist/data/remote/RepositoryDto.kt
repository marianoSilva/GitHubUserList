package com.example.githubuserlist.data.remote


import com.google.gson.annotations.SerializedName

data class RepositoryDto(

    @SerializedName("description")
    val description: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("name")
    val name: String,

)