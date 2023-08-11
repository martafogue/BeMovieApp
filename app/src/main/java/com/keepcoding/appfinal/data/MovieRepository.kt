package com.keepcoding.appfinal.data

import com.keepcoding.appfinal.domain.MovieModel

interface MovieRepository {
    suspend fun getMovieList(): List<MovieModel>
    suspend fun getMovieById(id: Int) : MovieModel
}