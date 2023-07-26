package com.example.githubuserlist.data.repository

import com.example.githubuserlist.data.mappers.toUserList
import com.example.githubuserlist.data.remote.GitHubUserListApi
import com.example.githubuserlist.data.remote.domain.repository.UserRepository
import com.example.githubuserlist.data.remote.domain.user.UserList
import com.example.githubuserlist.data.remote.domain.util.Resource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: GitHubUserListApi
) : UserRepository {
    override suspend fun getUser(): Resource<UserList> {
        return try {
            Resource.Success(
                data = api.getUserData().toUserList()
            )
        }catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Erro inesperado.")
        }
    }
}