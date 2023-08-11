package com.keepcoding.appfinal.data.mappers
import com.keepcoding.appfinal.data.local.model.MovieLocal
import com.keepcoding.appfinal.data.remote.dto.MovieDto
import com.keepcoding.appfinal.domain.MovieModel

fun MovieDto.toMovieModel() = MovieModel(
    id = id ?: 1,
    title = title ?: "",
    poster_path = poster_path ?: "",
    popularity = popularity ?: 1.0,
    overview = overview ?: "",
    release_date = release_date ?: "",
    vote_average = vote_average ?: 1.0,
    vote_count = vote_count ?: 1
)

fun MovieDto.toMovieLocal() = MovieLocal(
    id = id ?: 1,
    title = title ?: "",
    poster_path = poster_path ?: "",
    popularity = popularity ?: 1.0,
    overview = overview ?: "",
    release_date = release_date ?: "",
    vote_average = vote_average ?: 1.0,
    vote_count = vote_count ?: 1
)

fun MovieLocal.toMovieModel() = MovieModel(
    id = id ?: 1,
    title = title ?: "",
    poster_path = poster_path ?: "",
    popularity = popularity ?: 1.0,
    overview = overview ?: "",
    release_date = release_date ?: "",
    vote_average = vote_average ?: 1.0,
    vote_count = vote_count ?: 1
)