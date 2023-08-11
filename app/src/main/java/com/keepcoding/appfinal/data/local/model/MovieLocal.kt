package com.keepcoding.appfinal.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MovieTable")
data class MovieLocal(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "poster_path") val poster_path: String,
    @ColumnInfo(name = "popularity") val popularity: Double,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "release_date") val release_date: String,
    @ColumnInfo(name = "vote_average") val vote_average: Double,
    @ColumnInfo(name = "vote_count") val vote_count: Int
)