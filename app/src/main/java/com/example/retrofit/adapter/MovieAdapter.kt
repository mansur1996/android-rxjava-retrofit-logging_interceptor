package com.example.retrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.databinding.ItemMovieBinding
import com.example.retrofit.model.Movie
import com.squareup.picasso.Picasso

class MovieAdapter(val list : List<Movie>) : RecyclerView.Adapter<MovieAdapter.VH>() {

    inner class VH(val itemMovieBinding: ItemMovieBinding) : RecyclerView.ViewHolder(itemMovieBinding.root){
        fun onBind(movie: Movie){
            Picasso.get().load(movie.imageurl).into(itemMovieBinding.ivImg);
            itemMovieBinding.tvName.text = movie.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}