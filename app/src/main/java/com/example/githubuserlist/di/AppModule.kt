package com.example.githubuserlist.di

import com.example.githubuserlist.data.remote.GitHubUserListApi
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

object AppModule {
    @Provides
    @Singleton
    fun provideWeatherApi(): GitHubUserListApi {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}