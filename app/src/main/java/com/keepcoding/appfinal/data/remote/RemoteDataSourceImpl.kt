package com.keepcoding.appfinal.data.remote

import com.keepcoding.appfinal.data.remote.dto.MovieDto

class RemoteDataSourceImpl(
    private val movieApi: MovieApi
) : RemoteDataSource {
    //override suspend fun getMovieList(): List<MovieDto> = movieApi.getMovieList()
    override suspend fun getMovieList(): List<MovieDto> = movieApi.getMovieList().listaMovieDto
}