package com.example.githubuserlist.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.githubuserlist.presentation.detail.DetailViewModel

@Composable
fun DetailScreen(login: String){
    val viewModel: DetailViewModel = hiltViewModel()
    LaunchedEffect(Unit){
        viewModel.loadDetail(login)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()){
        Text(text = "Hello, ${viewModel.state.detailData?.name}.")
    }
}