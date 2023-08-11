package com.keepcoding.appfinal.data

import com.keepcoding.appfinal.data.mappers.toMovieModel
import com.keepcoding.appfinal.data.remote.dto.MovieDto
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MapperTest {

    @Test
    fun `WHEN toMovieModel with values EXPECT model has value`() {
        val movieDto = MovieDto(
            adult = false,
            backdrop_path = "",
            genre_ids = listOf(),
            id = 1,
            original_language = "",
            original_title = "",
            overview = "",
            popularity = 1.0,
            poster_path = "https://photo-url",
            release_date = "",
            title = "title 1",
            video = false,
            vote_average = 1.0,
            vote_count = 1
        )
        val res = movieDto.toMovieModel()

        MatcherAssert.assertThat(res.id, CoreMatchers.`is`(1))
    }

    @Test
    fun `WHEN toMovieModel with null EXPECT empty string`() {
        val movieDto = MovieDto(
            adult = false,
            backdrop_path = "",
            genre_ids = listOf(),
            id = 1,
            original_language = "",
            original_title = "",
            overview = "",
            popularity = 1.0,
            poster_path = "https://photo-url",
            release_date = "",
            title = "title 1",
            video = false,
            vote_average = 1.0,
            vote_count = 1
        )
        val res = movieDto.toMovieModel()

        assertThat(res.id, CoreMatchers.`is`(1))
    }
}