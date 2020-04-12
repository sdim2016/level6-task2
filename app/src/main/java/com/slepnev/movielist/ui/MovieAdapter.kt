package com.slepnev.movielist.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.slepnev.movielist.R
import com.slepnev.movielist.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(private val movies: List<Movie>,
                   private val onClick: (Movie) -> Unit
                   ) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position], position+1)
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onClick(movies[adapterPosition])
            }
        }

        fun bind(movie: Movie, number: Int) {
            itemView.tvNumber.text = "$number."
            Glide.with(context).load(movie.getPosterUrl()).into(itemView.ivPoster)
        }
    }

}