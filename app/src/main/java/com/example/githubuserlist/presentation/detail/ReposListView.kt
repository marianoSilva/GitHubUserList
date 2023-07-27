package com.example.githubuserlist.presentation.detail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp


@Composable
fun ReposListView(state: DetailState){
    state.detailData?.repos?.let {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = it,
                itemContent = {
                    ReposListItem(repo = it)
                }
            )
        }
    }
}