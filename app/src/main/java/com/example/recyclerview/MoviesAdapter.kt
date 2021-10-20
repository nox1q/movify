package com.example.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.movie_item.view.*
import kotlinx.android.synthetic.main.movie_recycler.view.*

class MoviesAdapter(
    private val movies: List<Movie>,
    private val onMovieClickListener: OnMovieClickListener
) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    class MovieViewHolder(
        private val view: View,
        private val onMovieClickListener: OnMovieClickListener
    ) : RecyclerView.ViewHolder(view) {
        fun bind(movie: Movie) = with(view) {
            iv_movie_poster.setOnClickListener {
                onMovieClickListener.onClick(movie)
            }

            val url = "https://image.tmdb.org/t/p/original/" + movie.poster
            Glide.with(iv_movie_poster)
                .load(url)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(8)))
                .into(iv_movie_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)

        return MovieViewHolder(view, onMovieClickListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size
}