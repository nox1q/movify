package com.example.recyclerview.home.presentation

import android.os.Bundle
import android.view.View
import com.example.recyclerview.MoviePreviewBottomSheet
import com.example.recyclerview.R
import com.example.recyclerview.common.BaseFragment
import com.example.recyclerview.common.observe
import com.example.recyclerview.home.domain.model.Movie
import com.example.recyclerview.home.presentation.adapter.MovieCategoryAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() = with(viewModel) {
        getCategoryMoviesLiveData().observe(viewLifecycleOwner, ::onCategoryMoviesLoaded)
        getShowMoviePreviewLiveData().observe(viewLifecycleOwner, ::showMoviePreview)
    }

    private fun onCategoryMoviesLoaded(categoryMoviePairs: List<Pair<String, List<Movie>>>) {
        rvCategoryMovies.adapter = MovieCategoryAdapter(
            categoryMoviePairs = categoryMoviePairs,
            onMovieClicked = viewModel::onMovieCLicked
        )
    }

    private fun showMoviePreview(movie: Movie) {
//        MoviePreviewBottomSheet.newInstance(movie)
//            .show(parentFragmentManager, "tag")
    }
}