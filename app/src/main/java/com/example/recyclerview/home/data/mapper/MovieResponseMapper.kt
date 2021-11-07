package com.example.recyclerview.home.data.mapper

import com.example.recyclerview.common.BASE_PHOTO_URL
import com.example.recyclerview.home.data.dto.MovieResponse
import com.example.recyclerview.home.data.dto.MovieResponseWrapper
import com.example.recyclerview.home.domain.model.Movie

private const val NO_ID = -1

class MovieResponseMapper {

    fun getMappedMovies(
        movieResponseWrapper: MovieResponseWrapper
    ): List<Movie> = movieResponseWrapper.movieResponses.map(::getMappedMovie)

    private fun getMappedMovie(movieResponse: MovieResponse) = Movie(
        id = movieResponse.id ?: NO_ID,
        title = movieResponse.title.orEmpty(),
        voteCount = movieResponse.voteCount,
        posterPath = BASE_PHOTO_URL + movieResponse.poster.orEmpty(),
        overview = movieResponse.overview.orEmpty()
    )
}