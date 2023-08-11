package com.keepcoding.appfinal.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.appfinal.data.remote.MovieApi
import com.keepcoding.appfinal.testUtil.DefaultDispatcherRule
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@ExperimentalCoroutinesApi
class ApiTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = DefaultDispatcherRule()

    private lateinit var api: MovieApi

    @Before
    fun setup() {
        api = retrofit.create(MovieApi::class.java)
    }

    @Test
    fun `When request movie list expect result`() = runTest {
        val result = api.getMovieList()
        assertThat(result.listaMovieDto.isNotEmpty(), CoreMatchers.`is`(true))
    }

    companion object {
        private lateinit var retrofit: Retrofit

        @BeforeClass
        @JvmStatic
        fun setupCommon() {
            retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(
                            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                                .apply {
                                    level = HttpLoggingInterceptor.Level.BODY
                                }).build()
                )
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder()
                            .addLast(KotlinJsonAdapterFactory())
                            .build()
                    )
                ).build()
        }
    }
}