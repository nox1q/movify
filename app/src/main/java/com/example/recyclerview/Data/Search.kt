package com.example.recyclerview.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search_query")
data class Search(
    var query: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}