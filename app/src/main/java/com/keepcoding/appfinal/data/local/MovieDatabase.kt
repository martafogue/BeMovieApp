package com.keepcoding.appfinal.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keepcoding.appfinal.data.local.model.MovieLocal

@Database(entities = [MovieLocal::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}