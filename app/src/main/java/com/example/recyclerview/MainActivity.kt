package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movie_recycler.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listOfMovieResponse: MutableList<MovieResponse> = mutableListOf()
        val listOfTopics = listOf("Popular", "Upcoming", "Now Playing", "Top Rated")
        bindApi(listOfMovieResponse, listOfTopics)
        tv_app_name.setOnClickListener {
            val dialog = BottomSheetDialog(this@MainActivity)
            val view = layoutInflater.inflate(R.layout.movie_bottom_sheet_layout, null)
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()
        }
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
                        listOfTopics
                    )
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
        class Child: OnMovieClickListener{
            override fun onClick(movie: Movie) {
                TODO("Not yet implemented")
            }
        }
    }

}