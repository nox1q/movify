package com.example.recyclerview.home.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val voteCount: Int?,
    val posterPath: String,
    val overview: String
)