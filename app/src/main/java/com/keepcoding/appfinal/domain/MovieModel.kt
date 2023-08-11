package com.keepcoding.appfinal.domain

data class MovieModel(
    val id: Int,
    val title: String,
    val poster_path: String,
    val popularity: Double,
    val overview: String?,
    val release_date: String?,
    val vote_average: Double?,
    val vote_count: Int?
)