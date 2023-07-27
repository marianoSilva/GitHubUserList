package com.example.githubuserlist.repository

import com.example.githubuserlist.data.remote.domain.repository.UserRepository
import com.example.githubuserlist.data.remote.domain.user.UserData
import com.example.githubuserlist.data.remote.domain.user.UserList
import com.example.githubuserlist.data.remote.domain.util.Resource


class FakeUserRepository: UserRepository {
    override suspend fun getUser(): Resource<UserList> {
        return try {
            Resource.Success(
                data = UserList(listOf(UserData("a","a","a","a","a"), UserData("a","a","a","a","a")))
            )
        }catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Erro inesperado.")
        }
    }
}