package com.example.recyclerview.Data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "search_query",indices = [Index(value = ["query"], unique = true)])
data class Search(
    var query: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}