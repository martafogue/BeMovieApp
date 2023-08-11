package com.keepcoding.appfinal.data.remote

import com.keepcoding.appfinal.data.remote.dto.MovieDto
import com.keepcoding.appfinal.data.remote.dto.ResultDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

const val TOKEN =
    "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmNDk4YzBlMDU5NjhkNzcwYjQzOTQ4NjBlNjQ4ODlmYiIsInN1YiI6IjY0YmNkZGEzODVjMGEyMDE0NDA3NDIzNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.eDlIh-JGg_S_dWow5BZJ530fJqFNb0jxgPuT6bY-f4Q"
const val API_KEY = "f498c0e05968d770b4394860e64889fb"

interface MovieApi {
    @GET("popular")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getMovieList() : ResultDto
    //suspend fun getResult(): ResultDto
    //suspend fun getMovieList() = getResult().results
}


