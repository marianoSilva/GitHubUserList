package com.example.githubuserlist.data.repository

import com.example.githubuserlist.data.mappers.toDetailData
import com.example.githubuserlist.data.mappers.toRepositoryList
import com.example.githubuserlist.data.remote.GitHubUserListApi
import com.example.githubuserlist.data.remote.domain.detail.DetailData
import com.example.githubuserlist.data.remote.domain.repository.DetailRepository
import com.example.githubuserlist.data.remote.domain.util.Resource
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val api: GitHubUserListApi
) : DetailRepository {
    override suspend fun getDetail(url: String): Resource<DetailData> {
        return try {
            Resource.Success(
                data = api.getDetailData(url).toDetailData(api.getRepositoryData(url).toRepositoryList().repos)
            )
        }catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Erro inesperado.")
        }
    }
}