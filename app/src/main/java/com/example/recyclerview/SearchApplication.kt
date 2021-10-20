package com.example.recyclerview

import android.app.Application
import com.example.recyclerview.Data.SearchDatabase
import com.example.recyclerview.Data.SearchQueryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class SearchApplication() : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { SearchDatabase.getSearchQueryDatabase(this) }
    val repository by lazy { SearchQueryRepository(database.searchDao()) }
}