package com.example.githubuserlist.repository

import com.example.githubuserlist.data.remote.domain.detail.DetailData
import com.example.githubuserlist.data.remote.domain.detail.RepositoryData
import com.example.githubuserlist.data.remote.domain.repository.DetailRepository
import com.example.githubuserlist.data.remote.domain.util.Resource

class FakeDetailRepository: DetailRepository {
    override suspend fun getDetail(url: String): Resource<DetailData> {
        return try {
            Resource.Success(
                data = DetailData(
                    "email",
                    "url",
                    2,
                    "sp",
                    "login",
                    "nome",
                    2,
                    listOf(RepositoryData("descri","nome"),RepositoryData("descri","nome"))
                )
            )
        }catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Erro inesperado.")
        }
    }
}