package com.example.githubuserlist.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.githubuserlist.presentation.detail.DetailViewModel
import com.example.githubuserlist.presentation.detail.ReposListView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(login: String){
    val viewModel: DetailViewModel = hiltViewModel()
    LaunchedEffect(Unit){
        viewModel.loadDetail(login)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Detalhes",fontWeight = FontWeight.Bold)
            }, Modifier.background(color = Color.LightGray))
        }
    ) { contentPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding)){
            Column(Modifier.fillMaxSize().padding(8.dp),) {
                Text(text = "Nome: ${viewModel.state.detailData?.name}.",
                    modifier = Modifier.padding(top = 10.dp))
                Text(text = "Email: ${viewModel.state.detailData?.email}.",
                modifier = Modifier.padding(top = 10.dp))
                Row(modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                    horizontalArrangement  =  Arrangement.SpaceBetween) {
                    Text(text = "Seguidores: ${viewModel.state.detailData?.followers}.")
                    Text(text = "Local: ${viewModel.state.detailData?.location}.")
                }
                Text(text = "Repositorios(${viewModel.state.detailData?.publicRepos}).",
                    modifier = Modifier.padding(top = 40.dp))
                ReposListView(state = viewModel.state)
            }
        }

    }
}