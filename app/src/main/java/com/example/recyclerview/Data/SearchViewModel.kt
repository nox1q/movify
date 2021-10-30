package com.example.recyclerview.Data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.recyclerview.Data.Search
import com.example.recyclerview.Data.SearchDatabase
import com.example.recyclerview.Data.SearchQueryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(application: Application) : AndroidViewModel(application) {
    val getSearchQueries: LiveData<List<Search>>
    private val repository: SearchQueryRepository

    init {
        val searchDao = SearchDatabase.getSearchQueryDatabase(application).searchDao()
        repository = SearchQueryRepository(searchDao)
        getSearchQueries = repository.getSearchQueries()
    }

    fun insertSearchQuery(search: Search) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertQuery(search)
        }
    }
}