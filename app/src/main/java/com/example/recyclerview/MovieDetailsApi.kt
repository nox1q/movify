package com.example.recyclerview

import android.os.Bundle
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.recyclerview.MovieDetailsActivity
import retrofit2.http.Path


interface MovieDetailsApi {

    @GET("3/movie/{id}")
    fun getMovieDetails(
        @Path("id") moveId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): Call<MovieDetails>

    companion object {
        operator fun invoke(): MovieDetailsApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieDetailsApi::class.java)
        }
    }
}