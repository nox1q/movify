package com.example.recyclerview

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(
    @SerializedName("id")
    val id:Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("vote_count")
    val voteCount: Int,
    @SerializedName("poster_path")
    val poster: String?
) : Serializable