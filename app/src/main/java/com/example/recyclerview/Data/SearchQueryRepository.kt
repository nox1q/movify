package com.example.recyclerview.Data

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.recyclerview.Data.Search
import com.example.recyclerview.Data.SearchDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchQueryRepository(
    private val searchDao: SearchDao
) {

    fun getSearchQueries(): LiveData<List<Search>> {
        return searchDao.getSearchQueries()
    }

    suspend fun insertQuery(search: Search) {
        searchDao.insertQuery(search)
    }

    fun searchDatabase(searchQuery: String): LiveData<List<Search>> {
        return searchDao.searchDatabase(searchQuery)
    }
}