package com.example.recyclerview

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieDetails(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("vote_count")
    val voteCount: Int?,
    @SerializedName("poster_path")
    val poster: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("genres")
    val genres: List<Genre>
) : Serializable
