package com.example.githubuserlist.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubuserlist.data.remote.domain.repository.DetailRepository
import com.example.githubuserlist.data.remote.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel@Inject constructor(private val repository: DetailRepository) : ViewModel() {

    var state by mutableStateOf(DetailState())
        private set

    fun loadDetail(url:String){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            when(val result = repository.getDetail(url)) {
                is Resource.Success -> {
                    state = state.copy(
                        detailData = result.data,
                        isLoading = false,
                        error = null
                    )
                }

                is Resource.Error -> {
                    state = state.copy(
                        detailData = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}