package com.example.githubuserlist.data.remote.domain.user


data class UserData(
    val avatarUrl: String,
    val htmlUrl: String,
    val login: String,
    val reposUrl: String,
    val url: String
){
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            login,
            "${login.first()}",
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}
