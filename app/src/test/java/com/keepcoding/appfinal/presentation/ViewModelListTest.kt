package com.keepcoding.appfinal.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.appfinal.MovieBuilderTest
import com.keepcoding.appfinal.domain.usecase.GetMovieListUseCase
import com.keepcoding.appfinal.presentation.list.MovieListViewModel
import com.keepcoding.appfinal.testUtil.DefaultDispatcherRule
import com.keepcoding.appfinal.testUtil.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ViewModelListTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getMovieListUseCase: GetMovieListUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @After
    fun tearDown() {
        // Liberar recursos del test
    }

    @Test
    fun `WHEN viewModel init EXPECT data at LiveData`() = runTest {
        coEvery { getMovieListUseCase.invoke() } returns MovieBuilderTest()
            .withNumElements(15)
            .buildList()

        val viewModel = MovieListViewModel(getMovieListUseCase)

        val res = viewModel.movieList.getOrAwaitValue()

        assertThat(res.size, CoreMatchers.`is`(15))

    }
}