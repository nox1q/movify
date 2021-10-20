package com.example.recyclerview

import android.view.View

interface OnQueryMovieClickListener {
    fun onQueryMovieClickListener(
        view: View,
        movieResponse: MovieResponse,
        position: Int,
        movieId: Int
    )
}