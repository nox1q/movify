package com.example.recyclerview.home

import com.google.gson.annotations.SerializedName

data class MovieResponseWrapper(
    @SerializedName("results")
    val movieResponses: List<MovieResponse>
)