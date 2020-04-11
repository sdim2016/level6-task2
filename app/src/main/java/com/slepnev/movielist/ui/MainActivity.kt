package com.slepnev.movielist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.slepnev.movielist.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initViewModel()
    }

    private fun initViews() {
        btnSubmit.setOnClickListener {
            viewModel.getMovies(etYear.text.toString())
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.moviesPage.observe(this, Observer {
            it?.movies?.forEach {
                var old = tvPopularMovies.text
                tvPopularMovies.text = "$old \n ${it.title}"
            }
        })
        viewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }
}
