package com.example.recyclerview.home.presentation.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.example.recyclerview.common.BaseViewHolder
import com.example.recyclerview.home.domain.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieViewHolder(
    private val view: View,
    private val onMovieClicked: (Movie) -> Unit
) : BaseViewHolder<Movie>(view) {

    override fun bind(model: Movie) = with(view) {
        Glide.with(this)
            .load(model.posterPath)
            .into(ivMoviePoster)

        ivMoviePoster.setOnClickListener { onMovieClicked(model) }
    }
}