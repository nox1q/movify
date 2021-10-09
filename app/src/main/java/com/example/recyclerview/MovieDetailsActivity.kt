package com.example.recyclerview

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.movie_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        MovieDetailsApi().getMovieDetails(intent.getIntExtra("movie_id", 0))
            .enqueue(object : Callback<MovieDetails> {
                override fun onResponse(
                    call: Call<MovieDetails>,
                    response: Response<MovieDetails>
                ) {
                    val movieDetails = response.body()
                    if (movieDetails != null) {
                        Log.d("error", movieDetails.id.toString())
                    } else {
                        Log.d("error", null.toString())
                    }
                    movieDetails?.let {
                        fetchData(movieDetails)
                    }

                }

                override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }

            })
    }

    fun fetchData(movieDetails: MovieDetails) {
        val url = "https://image.tmdb.org/t/p/w500/" + movieDetails.poster
        var isShow = true
        var scrollRange = -1
        app_bar_layout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { barLayout, verticalOffset ->
            if (scrollRange == -1) {
                scrollRange = barLayout?.totalScrollRange!!
            }
            if (scrollRange + verticalOffset == 0) {
                movie_title.title = movieDetails.title
                isShow = true
            } else if (isShow) {
                movie_title.title = " "
                isShow = false
            }
        })
        //tv_move_vote_count.text = movieDetails.voteCount.toString()
        tv_movie_vote_average.text = movieDetails.voteAverage.toString()
        //tv_movie_popularity.text = movieDetails.popularity.toString()
        tv_movie_overview.text = movieDetails.overview
        rv_movie_genres.adapter = MovieGenresAdapter(movieDetails.genres)
        Glide.with(iv_movie_poster)
            .load(url)
            .into(iv_movie_poster)

    }

}

