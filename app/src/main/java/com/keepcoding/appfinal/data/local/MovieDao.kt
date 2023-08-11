package com.keepcoding.appfinal.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.keepcoding.appfinal.data.local.model.MovieLocal

@Dao
interface MovieDao {
    @Query("SELECT * FROM MovieTable")
    suspend fun getAll(): List<MovieLocal>

    @Query("SELECT * FROM MovieTable WHERE id=:id")
    suspend fun getMovieById(id: kotlin.Int) : MovieLocal

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<MovieLocal>)

    @Delete
    suspend fun delete(model: MovieLocal)
}