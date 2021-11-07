package com.example.recyclerview.home.data.source

import com.example.recyclerview.API_KEY
import com.example.recyclerview.home.data.dto.MovieResponseWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieNetworkSource {
    @GET("3/movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String = API_KEY): Call<MovieResponseWrapper>

    @GET("3/movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String = API_KEY): Call<MovieResponseWrapper>

    @GET("3/movie/upcoming")
    fun getUpcomingMovies(@Query("api_key") apiKey: String = API_KEY): Call<MovieResponseWrapper>

    @GET("3/movie/now_playing")
    fun getNowPlayingMovies(@Query("api_key") apiKey: String = API_KEY): Call<MovieResponseWrapper>
}