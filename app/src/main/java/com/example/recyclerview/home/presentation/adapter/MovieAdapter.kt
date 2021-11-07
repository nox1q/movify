package com.example.recyclerview.home.presentation.adapter

import android.view.ViewGroup
import com.example.recyclerview.R
import com.example.recyclerview.common.BaseAdapter
import com.example.recyclerview.common.BaseViewHolder
import com.example.recyclerview.home.domain.model.Movie
import com.example.recyclerview.home.presentation.viewholder.MovieViewHolder

class MovieAdapter(
    movies: List<Movie>,
    private val onMovieClicked: (Movie) -> Unit
) : BaseAdapter<Movie>(movies) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<Movie> = MovieViewHolder(
        view = getInflatedView(R.layout.item_movie, parent),
        onMovieClicked = onMovieClicked
    )
}