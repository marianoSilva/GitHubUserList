package com.example.githubuserlist.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubuserlist.data.remote.domain.repository.UserRepository
import com.example.githubuserlist.data.remote.domain.user.UserList
import com.example.githubuserlist.data.remote.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository) : ViewModel(){
    var state by mutableStateOf(UserState())
        private set

    //Find users
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    var stateCache by mutableStateOf(UserState())

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
                    stateCache = state
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

    fun filterUserList(text: String){
        _searchText.value = text
        viewModelScope.launch() {
            state = state.copy(
                isLoading = true,
                error = null
            )
            if(text.isNotBlank()) {
                val userList = stateCache.userList?.let { UserList(it.users.filter { it.doesMatchSearchQuery(text) }) }
                state = state.copy(
                    userList = userList
                )

            }
        }
    }

}