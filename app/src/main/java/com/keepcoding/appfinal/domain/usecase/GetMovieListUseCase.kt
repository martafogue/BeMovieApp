package com.keepcoding.appfinal.domain.usecase

import com.keepcoding.appfinal.data.MovieRepository

class GetMovieListUseCase(
    private val movieRepository: MovieRepository
) {
    suspend fun invoke() = movieRepository.getMovieList()
}