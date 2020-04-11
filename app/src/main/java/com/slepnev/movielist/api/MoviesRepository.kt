package com.slepnev.movielist.api

class MoviesRepository {
    private val moviesApi: MoviesApiService = MoviesApi.createApi()

    fun getMovies(year: String) = moviesApi.getMoviesForYear(
        mapOf(
            "api_key" to "",
            "language" to "en-US",
            "sort_by" to "popularity.desc",
            "include_adult" to "false",
            "include_video" to "false",
            "page" to "1",
            "primary_release_year" to year)
    )
}