package com.keepcoding.appfinal.data.local

import com.keepcoding.appfinal.data.local.model.MovieLocal

class LocalDataSourceImpl(
    private val movieDao: MovieDao
) : LocalDataSource {
    override suspend fun insertMovieList(movieList: List<MovieLocal>) = movieDao.insertAll(movieList)
    override suspend fun getMovieList() : List<MovieLocal> = movieDao.getAll()
    override suspend fun getMovieById(id: Int): MovieLocal = movieDao.getMovieById(id)
}