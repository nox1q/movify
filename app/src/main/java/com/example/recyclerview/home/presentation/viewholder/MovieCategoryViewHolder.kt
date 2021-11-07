package com.example.recyclerview.home.presentation.viewholder

import android.view.View
import com.example.recyclerview.common.BaseViewHolder
import com.example.recyclerview.home.domain.model.Movie
import com.example.recyclerview.home.presentation.adapter.MovieAdapter
import kotlinx.android.synthetic.main.item_movies_category.view.*

class MovieCategoryViewHolder(
    private val view: View,
    private val onMovieClicked: (Movie) -> Unit
) : BaseViewHolder<Pair<String, List<Movie>>>(view) {

    override fun bind(model: Pair<String, List<Movie>>) = with(view) {
        tvMoviesCategory.text = model.first
        rvMovies.adapter = MovieAdapter(
            movies = model.second,
            onMovieClicked = onMovieClicked
        )
    }
}