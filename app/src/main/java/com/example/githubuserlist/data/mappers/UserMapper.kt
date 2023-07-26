package com.example.githubuserlist.data.mappers

import com.example.githubuserlist.data.remote.UserDtoList
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