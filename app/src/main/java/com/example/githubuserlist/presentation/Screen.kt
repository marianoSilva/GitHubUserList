package com.example.githubuserlist.presentation

sealed class Screen(var route: String){
    object HomeScreen: Screen("home_screen")
    object DetailScreen: Screen("detail_screen")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }
    }
}
