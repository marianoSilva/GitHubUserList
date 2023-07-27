package com.example.githubuserlist.data.mappers

import com.example.githubuserlist.data.remote.RepositoryDtoList
import com.example.githubuserlist.data.remote.UserDetailDto
import com.example.githubuserlist.data.remote.UserDtoList
import com.example.githubuserlist.data.remote.domain.detail.DetailData
import com.example.githubuserlist.data.remote.domain.detail.RepositoryData
import com.example.githubuserlist.data.remote.domain.detail.RepositoryList
import com.example.githubuserlist.data.remote.domain.user.UserData
import com.example.githubuserlist.data.remote.domain.user.UserList


fun UserDtoList.toUserList(): UserList{
    return UserList(
        map { UserData(
            avatarUrl = it.avatarUrl,
            htmlUrl = it.htmlUrl,
            login = it.login,
            reposUrl = it.reposUrl,
            url = it.url
        ) }

        )

}

fun UserDetailDto.toDetailData(repos: List<RepositoryData>): DetailData{
    return DetailData(
        email = email,
        eventsUrl = eventsUrl,
        followers = followers,
        location = location,
        login = login,
        name = name,
        publicRepos = publicRepos,
        repos = repos
    )

}


fun RepositoryDtoList.toRepositoryList(): RepositoryList{
    return RepositoryList(
        map { RepositoryData(
            description = it.description,
            name = it.name
        ) }
    )
}