package com.keepcoding.appfinal.domain.usecase

import com.keepcoding.appfinal.data.MovieRepository
import com.keepcoding.appfinal.domain.MovieModel

class GetDetailUseCase(
    private val movieRepository: MovieRepository
) {
    suspend fun invoke(id: Int) : MovieModel = movieRepository.getMovieById(id)
}