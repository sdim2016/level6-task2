package com.slepnev.movielist.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.slepnev.movielist.api.MoviesRepository
import com.slepnev.movielist.model.MoviePage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val moviesRepository = MoviesRepository(application.applicationContext)
    val moviesPage = MutableLiveData<MoviePage>()
    val error = MutableLiveData<String>()

    fun getMovies(year: String) {
        moviesRepository.getMovies(year).enqueue(object : Callback<MoviePage> {
            override fun onResponse(call: Call<MoviePage>, response: Response<MoviePage>) {
                if (response.isSuccessful) moviesPage.value = response.body()
                else error.value = "An error occurred: ${response.errorBody().toString()}"
            }

            override fun onFailure(call: Call<MoviePage>, t: Throwable) {
                error.value = t.message
            }
        })
    }
}