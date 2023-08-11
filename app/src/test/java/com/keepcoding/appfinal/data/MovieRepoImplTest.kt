package com.keepcoding.appfinal.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.appfinal.data.local.LocalDataSource
import com.keepcoding.appfinal.data.local.model.MovieLocal
import com.keepcoding.appfinal.data.remote.RemoteDataSource
import com.keepcoding.appfinal.data.remote.dto.MovieDto
import com.keepcoding.appfinal.testUtil.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieRepoImplTest {
    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var localDataSource: LocalDataSource

    @MockK(relaxed = true)
    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN getMovieList EXPECT local data`() = runTest {
        coEvery { localDataSource.getMovieList() } returns getListLocal()
        coEvery { remoteDataSource.getMovieList() } returns listOf<MovieDto>()

        val repo = MovieRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getMovieList()

        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(0))
    }

    @Test
    fun `WHEN getMovieList EXPECT remote data`() = runTest {
        coEvery { localDataSource.getMovieList() } returns listOf<MovieLocal>()
        coEvery { remoteDataSource.getMovieList() } returns getListRemote()

        val repo = MovieRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getMovieList()

        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(1))
    }
}

fun getListLocal() = listOf(
    MovieLocal(
        1,
        "title 1",
        "https://photo-url",
        1.0,
        overview = "",
        release_date = "",
        vote_average = 1.0,
        vote_count = 1
    )
)

fun getListRemote() = listOf<MovieDto>(
    MovieDto(
        adult = false,
        backdrop_path = "",
        genre_ids = listOf(),
        id = 1,
        original_language = "",
        original_title = "",
        overview = "",
        popularity = 1.0,
        poster_path = "https://photo-url",
        release_date = "",
        title = "title 1",
        video = false,
        vote_average = 1.0,
        vote_count = 1
    )
)