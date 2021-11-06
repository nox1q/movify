package com.example.recyclerview.home

private const val NO_ID = -1
private const val EMPTY_STRING = ""

class MovieResponseMapper {

    fun getMappedMovies(
        movieResponseWrapper: MovieResponseWrapper
    ): List<Movie> = movieResponseWrapper.movieResponses.map(::getMappedMovie)

    private fun getMappedMovie(movieResponse: MovieResponse) = Movie(
        id = movieResponse.id ?: NO_ID,
        title = movieResponse.title ?: EMPTY_STRING,
        voteCount = movieResponse.voteCount,
        posterPath = movieResponse.poster ?: EMPTY_STRING,
        overview = movieResponse.overview ?: EMPTY_STRING
    )
}