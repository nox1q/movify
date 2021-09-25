package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.movie_recycler.view.*

class MovieCategoryAdapter(
    private val moviesByCategory: List<MovieResponse>,
    private val categoryList: List<String>,
) :
    RecyclerView.Adapter<MovieCategoryAdapter.MovieCategoryViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieCategoryViewHolder {
        return MovieCategoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_recycler, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: MovieCategoryViewHolder,
        position: Int
    ) {
        val moviesAdapter = MoviesAdapter(moviesByCategory[position].movies)
        holder.itemView.tv_movie_topic.text = categoryList[position]
        holder.itemView.movies_recycler.adapter = moviesAdapter
    }

    override fun getItemCount(): Int = moviesByCategory.size

    class MovieCategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}