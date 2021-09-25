package com.example.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.movie_item.view.*
import kotlinx.android.synthetic.main.movie_recycler.view.*

class MoviesAdapter(
    private val movies: List<Movie>,
    private val onMovieClickListener: OnMovieClickListener
) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    class MovieViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: Movie) {
            val url = "https://image.tmdb.org/t/p/original/" + movie.poster
            Glide.with(view.iv_movie_poster)
                .load(url)
                .into(view.iv_movie_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
        holder.itemView.setOnClickListener {
            onMovieClickListener.onClick(movies[position])
        }

    }

    override fun getItemCount(): Int = movies.size
}