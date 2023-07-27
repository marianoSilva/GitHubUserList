package com.example.githubuserlist.presentation.detail

import com.example.githubuserlist.data.remote.domain.detail.DetailData

data class DetailState(
    val detailData: DetailData? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
