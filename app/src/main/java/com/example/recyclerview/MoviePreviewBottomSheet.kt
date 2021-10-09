package com.example.recyclerview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.movie_bottom_sheet_layout.*
import kotlinx.android.synthetic.main.movie_bottom_sheet_layout.view.*
import kotlinx.android.synthetic.main.movie_item.*

class MoviePreviewBottomSheet() : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_bottom_sheet_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.tv_movie_title.text = arguments?.getString("title")
        view.tv_movie_description.text = arguments?.getString("overview")
        val url = "https://image.tmdb.org/t/p/original/" + arguments?.getString("poster_path")
        onLearnMoreClickListener()
        Glide.with(view.iv_movie_poster)
            .load(url)
            .into(view.iv_movie_poster)
    }

    private fun onLearnMoreClickListener() {
        ll_learn_more.setOnClickListener {
            val intent = Intent(activity, MovieDetailsActivity::class.java)
            intent.putExtra("movie_id",arguments?.getInt("id"))
            startActivity(intent)
        }
    }

    companion object {
        fun newInstance(movie: Movie): MoviePreviewBottomSheet {
            val fragment = MoviePreviewBottomSheet()
            val arguments = Bundle()
            arguments.putInt("id",movie.id!!)
            arguments.putString("poster_path", movie.poster)
            arguments.putString("title", movie.title)
            arguments.putString("overview", movie.overview)
            arguments.putInt("vote_count", movie.voteCount)
            fragment.arguments = arguments
            return fragment
        }
    }
}