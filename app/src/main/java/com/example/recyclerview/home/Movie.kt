package com.example.recyclerview.home

data class Movie(
    val id: Int,
    val title: String,
    val voteCount: Int?,
    val posterPath: String,
    val overview: String
)