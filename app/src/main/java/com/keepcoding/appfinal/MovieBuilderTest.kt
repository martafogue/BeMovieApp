package com.keepcoding.appfinal

import com.keepcoding.appfinal.domain.MovieModel

class MovieBuilderTest {
    val id = 1
    var title = ""
    var poster_path = ""
    var overview = ""
    var popularity = 1.0
    var release_date = ""
    var vote_average = 1.0
    var vote_count = 5
    var numElements: Int = 1

    fun withTitle(title: String): MovieBuilderTest {
        this.title = title
        return this
    }

    fun withPosterPath(poster_path: String): MovieBuilderTest {
        this.poster_path = poster_path
        return this
    }

    fun withOverview(overview: String): MovieBuilderTest {
        this.overview = overview
        return this
    }

    fun withPopularity(popularity: Double): MovieBuilderTest {
        this.popularity = popularity
        return this
    }

    fun withDate(release_date: String): MovieBuilderTest {
        this.release_date = release_date
        return this
    }

    fun withVoteCount(vote_count: Int): MovieBuilderTest {
        this.vote_count = vote_count
        return this
    }

    fun withVoteAverage(vote_average: Double): MovieBuilderTest {
        this.vote_average = vote_average
        return this
    }

    fun withNumElements(numElements: Int): MovieBuilderTest {
        this.numElements = numElements
        return this
    }

    fun buildList(): List<MovieModel> {
        val list = mutableListOf<MovieModel>()

        for(i in 0 until numElements) {
            list.add(
                MovieModel(
                    id,
                    title = title,
                    poster_path = poster_path,
                    overview = overview,
                    popularity = popularity,
                    release_date = release_date,
                    vote_count = vote_count,
                    vote_average = vote_average
                )
            )
        }

        return list.toList()
    }

    fun buildSingle() = MovieModel(
        id,
        title = title,
        poster_path = poster_path,
        overview = overview,
        popularity = popularity,
        release_date = release_date,
        vote_count = vote_count,
        vote_average = vote_average
    )
}