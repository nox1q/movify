package com.example.recyclerview

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "4a652d0f98be45dce5844b33c16285c2"
const val BASE_URL = "https://api.themoviedb.org/"

interface MoviesApi {
    @GET("3/movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String = API_KEY): Call<MovieResponse>

    @GET("3/movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String = API_KEY): Call<MovieResponse>

    @GET("3/movie/upcoming")
    fun getUpcomingMovies(@Query("api_key") apiKey: String = API_KEY): Call<MovieResponse>

    @GET("3/movie/now_playing")
    fun getNowPlayingMovies(@Query("api_key") apiKey: String = API_KEY): Call<MovieResponse>

    companion object {
        operator fun invoke(): MoviesApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MoviesApi::class.java)
        }
    }

}