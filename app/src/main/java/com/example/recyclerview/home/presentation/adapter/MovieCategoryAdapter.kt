package com.example.recyclerview.home.presentation.adapter

import android.view.ViewGroup
import com.example.recyclerview.R
import com.example.recyclerview.common.BaseAdapter
import com.example.recyclerview.common.BaseViewHolder
import com.example.recyclerview.home.domain.model.Movie
import com.example.recyclerview.home.presentation.viewholder.MovieCategoryViewHolder

class MovieCategoryAdapter(
    categoryMoviePairs: List<Pair<String, List<Movie>>>,
    private val onMovieClicked: (Movie) -> Unit
) : BaseAdapter<Pair<String, List<Movie>>>(categoryMoviePairs) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<Pair<String, List<Movie>>> = MovieCategoryViewHolder(
        view = getInflatedView(R.layout.item_movies_category, parent),
        onMovieClicked = onMovieClicked
    )
}