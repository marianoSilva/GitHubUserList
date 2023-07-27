package com.example.githubuserlist.presentation.user

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.githubuserlist.repository.FakeUserRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain

import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.rules.TestRule

class UserViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    private val viewModel = UserViewModel(FakeUserRepository())

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun `load user list not null`(){
        viewModel.loadUserList()
        dispatcher.scheduler.advanceUntilIdle()
        assertThat(viewModel.state.userList).isNotNull()
    }

    @Test
    fun `state cache is equal state`(){
        viewModel.loadUserList()
        dispatcher.scheduler.advanceUntilIdle()
        assertThat(viewModel.stateCache).isEqualTo(viewModel.state)
    }

    @Test
    fun `filter list works`(){
        viewModel.loadUserList()
        viewModel.filterUserList("b")
        dispatcher.scheduler.advanceUntilIdle()
        assertThat(viewModel.stateCache).isNotEqualTo(viewModel.state)
    }

    @Test
    fun `empty filter return original user list`(){
        viewModel.loadUserList()
        viewModel.filterUserList("")
        dispatcher.scheduler.advanceUntilIdle()
        assertThat(viewModel.stateCache).isEqualTo(viewModel.state)
    }

}