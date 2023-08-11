package com.keepcoding.appfinal.data.local

import com.keepcoding.appfinal.data.local.model.MovieLocal

interface LocalDataSource {
    suspend fun insertMovieList(movieList: List<MovieLocal>)
    suspend fun getMovieList() : List<MovieLocal>
    suspend fun getMovieById(id: Int) : MovieLocal
}