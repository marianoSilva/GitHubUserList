package com.example.githubuserlist.data.remote.domain.detail


data class DetailData(
    val email: String?,
    val eventsUrl: String?,
    val followers: Int?,
    val location: String?,
    val login: String?,
    val name: String?,
    val publicRepos: Int?,
    val repos: List<RepositoryData>

)
