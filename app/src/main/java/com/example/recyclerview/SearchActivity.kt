package com.example.recyclerview

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.Data.Search
import com.example.recyclerview.Data.SearchQueryRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_search_list_screen.*

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        rv_search_queries.layoutManager = LinearLayoutManager(this)
        rv_search_queries.adapter = SearchQueryAdapter()
    }

    private fun searching(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val intent =
                    Intent(this@SearchActivity, SearchListScreenActivity::class.java).apply {
                        putExtra("query", query)
                    }
                startActivity(intent)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_list_toolbar_menu, menu)
        val searchItem: MenuItem = menu.findItem(R.id.action_search)
        val searchView: SearchView = searchItem.actionView as SearchView
        searching(searchView)
        val searchText: TextView? = searchView.findViewById(androidx.appcompat.R.id.search_src_text)
        searchText?.setTextColor(Color.WHITE)
        searchView.isFocusable = true
        searchView.maxWidth = Int.MAX_VALUE
        searchView.isIconified = false
        searchView.isFocusable = false
        searchView.clearFocus()
        searchView.onActionViewExpanded()
        return true
    }


}