package com.example.recyclerview.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerview.home.domain.model.Movie
import com.example.recyclerview.home.domain.usecase.GetMovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val getMovieUseCase: GetMovieUseCase,
) : ViewModel() {

    private val categoryMoviesLiveData = MutableLiveData<List<Pair<String, List<Movie>>>>()
    private val showMoviePreviewLiveData = MutableLiveData<Movie>()

    fun getCategoryMoviesLiveData(): LiveData<List<Pair<String, List<Movie>>>> = categoryMoviesLiveData
    fun getShowMoviePreviewLiveData(): LiveData<Movie> = showMoviePreviewLiveData

    init {
        loadCategoryMovies()
    }

    fun onMovieCLicked(movie: Movie) {
        showMoviePreviewLiveData.value = movie
    }

    private fun loadCategoryMovies() = viewModelScope.launch {
        val categoryMovies: List<Pair<String, List<Movie>>> = withContext(Dispatchers.IO) {
            getMovieUseCase.execute()
        }
        categoryMoviesLiveData.value = categoryMovies
    }
}