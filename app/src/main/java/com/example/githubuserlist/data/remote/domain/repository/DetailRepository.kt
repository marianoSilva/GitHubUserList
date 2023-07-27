package com.example.githubuserlist.data.remote.domain.repository

import com.example.githubuserlist.data.remote.domain.detail.DetailData
import com.example.githubuserlist.data.remote.domain.util.Resource

interface DetailRepository {

    suspend fun getDetail(url: String) : Resource<DetailData>
}