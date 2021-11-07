package com.example.recyclerview.home.domain.usecase

import android.util.Log
import com.example.recyclerview.common.Response
import com.example.recyclerview.home.domain.model.Movie
import com.example.recyclerview.home.domain.repository.MovieRepository

internal const val KEY_POPULAR_MOVIES = "Popular Movies"
internal const val KEY_TOP_RATED_MOVIES = "Top Rated Movies"
internal const val KEY_UPCOMING_MOVIES = "Upcoming Movies"
internal const val KEY_NOW_PLAYING_MOVIES = "Now Playing Movies"

class GetMovieUseCase(
    private val movieRepository: MovieRepository
) {

    fun execute(): List<Pair<String, List<Movie>>> {
        val categoryMoviePairs: MutableList<Pair<String, List<Movie>>> = mutableListOf()

        val popularMoviesResponse = movieRepository.getPopularMovies()
        val topRatedMoviesResponse = movieRepository.getTopRatedMovies()
        val upcomingMoviesResponse = movieRepository.getUpcomingMovies()
        val nowPlayingMoviesResponse = movieRepository.getNowPlayingMovies()

        handleResponse(
            response = popularMoviesResponse,
            moviesKey = KEY_POPULAR_MOVIES,
            categoryMoviePairs = categoryMoviePairs
        )
        handleResponse(
            response = topRatedMoviesResponse,
            moviesKey = KEY_TOP_RATED_MOVIES,
            categoryMoviePairs = categoryMoviePairs
        )
        handleResponse(
            response = upcomingMoviesResponse,
            moviesKey = KEY_UPCOMING_MOVIES,
            categoryMoviePairs = categoryMoviePairs
        )
        handleResponse(
            response = nowPlayingMoviesResponse,
            moviesKey = KEY_NOW_PLAYING_MOVIES,
            categoryMoviePairs = categoryMoviePairs
        )

        return categoryMoviePairs
    }

    private fun handleResponse(
        response: Response<List<Movie>, Exception>,
        moviesKey: String,
        categoryMoviePairs: MutableList<Pair<String, List<Movie>>>
    ) = when (response) {
        is Response.Success -> categoryMoviePairs.add(Pair(moviesKey, response.result))
        is Response.Error -> Log.d("Nursultan", "${response.error.javaClass.name}")
    }
}