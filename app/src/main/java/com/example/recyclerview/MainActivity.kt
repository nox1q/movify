package com.example.recyclerview

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.get
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movie_bottom_sheet_layout.*
import kotlinx.android.synthetic.main.movie_bottom_sheet_layout.view.*
import kotlinx.android.synthetic.main.movie_recycler.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), OnMovieClickListener {
    override fun onClick(movie: Movie) {
        MoviePreviewBottomSheet.newInstance(movie).show(supportFragmentManager, "tag")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)

        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        action_search.setOnClickListener {
//            val intent = Intent(this, SearchActivity::class.java)
//            startActivity(intent)
//        }
        val listOfMovieResponse: MutableList<MovieResponse> = mutableListOf()
        val listOfTopics = listOf("Popular", "Upcoming", "Now Playing", "Top Rated")
        bindApi(listOfMovieResponse, listOfTopics)
    }

    private fun bindApi(
        listOfMovieResponse: MutableList<MovieResponse>,
        listOfTopics: List<String>
    ) {
        MoviesApi().getPopularMovies().enqueue(object : Callback<MovieResponse> {

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val movies = response.body()
                movies?.let {
                    listOfMovieResponse.add(movies)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
        MoviesApi().getUpcomingMovies().enqueue(object : Callback<MovieResponse> {

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val movies = response.body()
                movies?.let {
                    listOfMovieResponse.add(movies)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
        MoviesApi().getTopRatedMovies().enqueue(object : Callback<MovieResponse> {

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val movies = response.body()
                movies?.let {
                    listOfMovieResponse.add(movies)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
        MoviesApi().getNowPlayingMovies().enqueue(object : Callback<MovieResponse> {

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val movies = response.body()
                movies?.let {
                    listOfMovieResponse.add(movies)

                    PopularMovies.adapter = MovieCategoryAdapter(
                        listOfMovieResponse,
                        listOfTopics,
                        this@MainActivity
                    )
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

}