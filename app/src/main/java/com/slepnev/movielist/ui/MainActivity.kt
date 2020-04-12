package com.slepnev.movielist.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.slepnev.movielist.R
import com.slepnev.movielist.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private val movies = arrayListOf<Movie>()
    private val movieAdapter = MovieAdapter(movies)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initViewModel()
    }

    private fun initViews() {
        rvMovies.layoutManager = GridLayoutManager(this@MainActivity, 2)
        rvMovies.adapter = movieAdapter

        btnSubmit.setOnClickListener {
            //viewModel.getMovies(etYear.text.toString())
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.moviesPage.observe(this, Observer {
            movies.clear()
            movies.addAll(it.movies)
            movieAdapter.notifyDataSetChanged()
        })
        viewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }
}
