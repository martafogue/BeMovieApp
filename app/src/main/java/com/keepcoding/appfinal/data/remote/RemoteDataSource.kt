package com.keepcoding.appfinal.data.remote

import com.keepcoding.appfinal.data.remote.dto.MovieDto

interface RemoteDataSource {
    suspend fun getMovieList(): List<MovieDto>
}