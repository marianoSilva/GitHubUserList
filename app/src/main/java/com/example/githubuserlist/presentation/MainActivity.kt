package com.example.githubuserlist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.githubuserlist.presentation.ui.theme.GitHubUserListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitHubUserListTheme {
                Navigation()
            }
        }
    }
    @Composable
    fun Navigation(){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.HomeScreen.route ){
            composable(route = Screen.HomeScreen.route){
                NavHomeScreen( navController)
            }
            composable(
                route = Screen.DetailScreen.route+"/{login}",
                arguments = listOf(
                    navArgument("login"){
                        type = NavType.StringType
                        defaultValue = "Mariano"
                        nullable = true
                    }
                )
            ){entry ->
                entry.arguments?.getString("login")?.let { DetailScreen(login = it) }
            }
        }
    }

//    @Composable
//    inline fun <reified T : ViewModel> NavBackStackEntry?.viewModel(): T? = this?.let {
//        viewModel(viewModelStoreOwner = it)
//    }
//
//    @Composable
//    inline fun <reified T : ViewModel> NavBackStackEntry.viewModel(
//        viewModelStoreOwner: ViewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
//            "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
//        }
//    ): T {
//        return androidx.lifecycle.viewmodel.compose.viewModel(
//            viewModelStoreOwner = viewModelStoreOwner, key = T::class.java.name
//        )
//    }
}





