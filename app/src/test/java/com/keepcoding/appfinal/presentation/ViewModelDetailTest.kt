package com.keepcoding.appfinal.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.appfinal.MovieBuilderTest
import com.keepcoding.appfinal.domain.usecase.GetDetailUseCase
import com.keepcoding.appfinal.presentation.detail.MovieDetailViewModel
import com.keepcoding.appfinal.testUtil.DefaultDispatcherRule
import com.keepcoding.appfinal.testUtil.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ViewModelDetailTest {
    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getDetailUseCase: GetDetailUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN detail viewModel getData EXPECT returns data`() = runTest {
        coEvery { getDetailUseCase.invoke(1) } returns
                MovieBuilderTest().buildSingle()

        val viewModel = MovieDetailViewModel(getDetailUseCase)

        viewModel.getMovie(1)

        val res = viewModel.movie.getOrAwaitValue()

        assertThat(res.id, CoreMatchers.`is`(1))
    }
}