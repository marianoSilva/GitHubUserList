package com.example.githubuserlist.presentation.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun UserListView(state: UserState){
    state.userList?.users?.let {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = it,
                itemContent = {
                    UserListItem(user = it)
                }
            )
        }
    }
}
