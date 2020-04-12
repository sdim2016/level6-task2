package com.slepnev.movielist.ui

import android.app.Application
import android.view.View
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
    val progressBarStatus = MutableLiveData<Boolean>(false)

    fun getMovies(year: String) {
        progressBarStatus.value = true
        moviesRepository.getMovies(year).enqueue(object : Callback<MoviePage> {
            override fun onResponse(call: Call<MoviePage>, response: Response<MoviePage>) {
                if (response.isSuccessful) moviesPage.value = response.body()
                else error.value = "An error occurred: ${response.errorBody().toString()}"
                progressBarStatus.value = false
            }

            override fun onFailure(call: Call<MoviePage>, t: Throwable) {
                error.value = t.message
                progressBarStatus.value = false
            }
        })
    }
}