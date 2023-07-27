package com.example.githubuserlist.data.remote


import com.google.gson.annotations.SerializedName

data class RepositoryDto(

    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String,

)