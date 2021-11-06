package com.example.recyclerview.home

import androidx.annotation.WorkerThread

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