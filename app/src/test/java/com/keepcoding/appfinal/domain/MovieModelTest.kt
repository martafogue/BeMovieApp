package com.keepcoding.appfinal.domain

import com.keepcoding.appfinal.MovieBuilderTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test

class MovieModelTest {

    var movieModel = MovieModel(
        1,
        "title 1",
        "https://photo-url",
        1.0,
        overview = "",
        release_date = "",
        vote_average = 1.0,
        vote_count = 1
    )

    @Test
    fun `WHEN create model EXPECT not null value`() {
        MatcherAssert.assertThat(movieModel, CoreMatchers.instanceOf(MovieModel::class.java))
        MatcherAssert.assertThat(movieModel, CoreMatchers.notNullValue())
    }

    @Test
    fun `WHEN movieModel id is 2 EXPECT id = 2`() {
        val movie = MovieBuilderTest()
            .buildSingle()
        MatcherAssert.assertThat(movie.id, CoreMatchers.`is`(1))
    }
}