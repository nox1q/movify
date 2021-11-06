package com.example.recyclerview.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val movieLoadErrorLiveData = MutableLiveData<Exception>()
    private val movieListsLiveData = MutableLiveData<Map<String, List<Movie>>>()

    init {

    }

    fun onMovieCLicked(movie: Movie) {

    }
}