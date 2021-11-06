package com.example.recyclerview.home

import com.example.recyclerview.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieNetworkSource {
    @GET("3/movie/popular")
    fun getPopularMovies(): Call<MovieResponseWrapper>

    @GET("3/movie/top_rated")
    fun getTopRatedMovies(): Call<MovieResponseWrapper>

    @GET("3/movie/upcoming")
    fun getUpcomingMovies(): Call<MovieResponseWrapper>

    @GET("3/movie/now_playing")
    fun getNowPlayingMovies(): Call<MovieResponseWrapper>
}