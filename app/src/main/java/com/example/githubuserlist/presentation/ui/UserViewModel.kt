package com.example.githubuserlist.presentation.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubuserlist.data.remote.domain.repository.UserRepository
import com.example.githubuserlist.data.remote.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository) : ViewModel(){

    var state by mutableStateOf(UserState())
        private set

    fun loadUserList(){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            when(val result = repository.getUser()) {
                is Resource.Success -> {
                    state = state.copy(
                        userList = result.data,
                        isLoading = false,
                        error = null
                    )
                }

                is Resource.Error -> {
                    state = state.copy(
                        userList = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
            }
        }
}