package com.slepnev.movielist.api

import com.slepnev.movielist.model.MoviePage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

public interface MoviesApiService {
    @GET("/3/discover/movie")
    fun getMoviesForYear(@QueryMap params: Map<String, String>): Call<List<MoviePage>>
}