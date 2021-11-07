package com.example.recyclerview.home.domain.repository

import androidx.annotation.WorkerThread
import com.example.recyclerview.common.Response
import com.example.recyclerview.home.domain.model.Movie

interface MovieRepository {
    @WorkerThread
    fun getPopularMovies(): Response<List<Movie>, Exception>

    @WorkerThread
    fun getTopRatedMovies(): Response<List<Movie>, Exception>

    @WorkerThread
    fun getUpcomingMovies(): Response<List<Movie>, Exception>

    @WorkerThread
    fun getNowPlayingMovies(): Response<List<Movie>, Exception>
}