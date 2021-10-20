package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.recyclerview.Data.SearchQueryRepository
import kotlinx.android.synthetic.main.activity_search_list_screen.*
import kotlinx.android.synthetic.main.query_item.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchListScreenActivity : AppCompatActivity(), OnQueryMovieClickListener {

    override fun onQueryMovieClickListener(
        view: View,
        movieResponse: MovieResponse,
        position: Int,
        movieId: Int
    ) {
        val clickedMovieId = movieResponse.movies[position].id
        val intent = Intent(this, MovieDetailsActivity::class.java).apply {
            putExtra("movie_id", clickedMovieId)
        }
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_list_screen)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        intent.getStringExtra("query")?.let { bindApi(it) }
    }

    private fun bindApi(query: String) {
        MoviesApi().getQueryMovies(query, 1).enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val movies = response.body()
                movies?.let {
                    rv_movie_queries.adapter = QueryListAdapter(
                        movies,
                        this@SearchListScreenActivity
                    )
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> startActivity(Intent(this, MainActivity::class.java))
        }
        return true
    }


}