package com.example.recyclerview.Data

import androidx.annotation.WorkerThread
import com.example.recyclerview.Data.Search
import com.example.recyclerview.Data.SearchDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchQueryRepository(
    private val searchDao: SearchDao
) {

    fun getSearchQueries(): List<Search> {
        return searchDao.getSearchQueries()
    }

    fun insertQuery(search: Search) {
        searchDao.insertQuery(search)
    }

    fun searchDatabase(searchQuery: String): List<Search> {
        return searchDao.searchDatabase(searchQuery)
    }
}