package com.example.githubuserlist.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.githubuserlist.repository.FakeDetailRepository
import com.google.common.truth.Truth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class DetailViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    private val viewModel = DetailViewModel(FakeDetailRepository())

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun `load detail list not null`() {
        viewModel.loadDetail("url")
        dispatcher.scheduler.advanceUntilIdle()
        Truth.assertThat(viewModel.state.detailData).isNotNull()
    }
}

