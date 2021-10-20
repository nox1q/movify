package com.example.recyclerview.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recyclerview.Data.Search
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchDao {

    @Query("SELECT * FROM search_query ORDER BY id ASC")
    fun getSearchQueries(): List<Search>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertQuery(search: Search)

    @Query("SELECT * FROM search_query WHERE `query` LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): List<Search>
}