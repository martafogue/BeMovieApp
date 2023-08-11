package com.keepcoding.appfinal.data.remote.dto

import com.squareup.moshi.Json

data class ResultDto(
    @Json(name="results") val listaMovieDto: List<MovieDto>
)
