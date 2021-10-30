package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.query_item.view.*
import kotlinx.android.synthetic.main.query_item.view.iv_movie_poster

class QueryListAdapter(
    private val movies: MovieResponse,
    private val onQueryMovieClickListener: OnQueryMovieClickListener
) : RecyclerView.Adapter<QueryListAdapter.QueryListViewHolder>() {

    class QueryListViewHolder(
        private val view: View,
        private val onQueryMovieClickListener: OnQueryMovieClickListener

    ) : RecyclerView.ViewHolder(view) {
        fun bind(movie: MovieResponse) = with(view) {
            view.setOnClickListener {
                movie.movies[position].id?.let { it1 ->
                    onQueryMovieClickListener.onQueryMovieClicked(
                        view,
                        movie,
                        position,
                        it1
                    )
                }
            }
            tv_movie_title.text = movie.movies[position].title.toString()
            tv_movie_description.text = movie.movies[position].overview.toString()
            val url = "https://image.tmdb.org/t/p/original/" + movie.movies[position].poster
            Glide.with(iv_movie_poster)
                .load(url)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(8)))
                .into(iv_movie_poster)
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QueryListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.query_item, parent, false)
        return QueryListViewHolder(view, onQueryMovieClickListener)
    }

    override fun onBindViewHolder(
        holder: QueryListViewHolder,
        position: Int
    ) {
        holder.bind(movies)
    }

    override fun getItemCount(): Int = movies.movies.size
}