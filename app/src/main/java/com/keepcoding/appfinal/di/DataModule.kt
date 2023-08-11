package com.keepcoding.appfinal.di

import android.content.Context
import androidx.room.Room
import com.keepcoding.appfinal.data.local.MovieDao
import com.keepcoding.appfinal.data.local.MovieDatabase
import com.keepcoding.appfinal.data.local.LocalDataSource
import com.keepcoding.appfinal.data.local.LocalDataSourceImpl
import com.keepcoding.appfinal.data.remote.RemoteDataSource
import com.keepcoding.appfinal.data.remote.RemoteDataSourceImpl
import com.keepcoding.appfinal.data.remote.MovieApi
import com.keepcoding.appfinal.data.MovieRepository
import com.keepcoding.appfinal.data.MovieRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }

    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }

    single<LocalDataSource> { LocalDataSourceImpl(get()) }

    single<MovieApi> {
        getMovieApi(get())
    }

    single {
        getDatabase(get())
    }

    single {
        providesMovieDao(get())
    }
}

private fun getMovieApi(retrofit: Retrofit) =
    retrofit.create(MovieApi::class.java)

private fun getDatabase(context: Context) : MovieDatabase =
    Room.databaseBuilder(
        context,
        MovieDatabase::class.java, "movie_db"
    ).build()

private fun providesMovieDao(db: MovieDatabase) : MovieDao =
    db.movieDao()

