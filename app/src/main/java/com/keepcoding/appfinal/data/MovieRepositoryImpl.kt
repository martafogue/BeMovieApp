package com.keepcoding.appfinal.data

import android.util.Log
import com.keepcoding.appfinal.data.local.LocalDataSource
import com.keepcoding.appfinal.data.mappers.toMovieLocal
import com.keepcoding.appfinal.domain.MovieModel
import com.keepcoding.appfinal.data.remote.RemoteDataSource
import com.keepcoding.appfinal.data.mappers.toMovieModel

class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : MovieRepository {

    override suspend fun getMovieList(): List<MovieModel> {
        val remoteData = remoteDataSource.getMovieList().filter {
            //it.id == null
            it.title?.isNotEmpty() == true
        }
        localDataSource.insertMovieList(remoteData.map { it.toMovieLocal() })

        /*return remoteData.map {
            it.toMovieModel()
        }*/

        val localData = localDataSource.getMovieList()

        if (localData.isNotEmpty()) {
            return localData.map { it.toMovieModel() }
        } else {
            val remoteData = remoteDataSource.getMovieList().filter {
                it.id == null
            }
            localDataSource.insertMovieList(remoteData.map { it.toMovieLocal() })

            return remoteData.map {
                it.toMovieModel()
            }
            Log.d("PRUEBA", remoteData.get(0).title!!)
        }
    }

    override suspend fun getMovieById(id: Int): MovieModel {
        return localDataSource.getMovieById(id).toMovieModel()
    }
}