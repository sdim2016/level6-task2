package com.slepnev.movielist.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("title") var title: String,
    @SerializedName("backdrop_path") var backdropImage: String,
    @SerializedName("poster_path") var posterImage: String,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("vote_average") var rating: Int,
    @SerializedName("overview") var overview: String
) {
    fun getBackdropUrl() = "https://image.tmdb.org/t/p/w300/$backdropImage"
    fun getPosterUrl() = "https://image.tmdb.org/t/p/w185/$posterImage"
}