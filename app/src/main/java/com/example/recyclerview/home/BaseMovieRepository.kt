package com.example.recyclerview.home

class BaseMovieRepository(
    private val movieNetworkSource: MovieNetworkSource,
    private val movieResponseMapper: MovieResponseMapper
) : MovieRepository {

    override fun getPopularMovies(): Response<List<Movie>, Exception> {
        val response = movieNetworkSource.getPopularMovies().executeCall()

        return when (response) {
            is Response.Success -> Response.Success(movieResponseMapper.getMappedMovies(response.result))
            is Response.Error -> Response.Error(response.error)
        }
    }

    override fun getTopRatedMovies(): Response<List<Movie>, Exception> {
        val response = movieNetworkSource.getTopRatedMovies().executeCall()

        return when (response) {
            is Response.Success -> Response.Success(movieResponseMapper.getMappedMovies(response.result))
            is Response.Error -> Response.Error(response.error)
        }
    }

    override fun getUpcomingMovies(): Response<List<Movie>, Exception> {
        val response = movieNetworkSource.getUpcomingMovies().executeCall()

        return when (response) {
            is Response.Success -> Response.Success(movieResponseMapper.getMappedMovies(response.result))
            is Response.Error -> Response.Error(response.error)
        }
    }

    override fun getNowPlayingMovies(): Response<List<Movie>, Exception> {
        val response = movieNetworkSource.getNowPlayingMovies().executeCall()

        return when (response) {
            is Response.Success -> Response.Success(movieResponseMapper.getMappedMovies(response.result))
            is Response.Error -> Response.Error(response.error)
        }
    }
}