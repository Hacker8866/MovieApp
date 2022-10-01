package com.example.movieapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_layput.view.*

class MyMovieAdapter(var context: Context, var movieList: ArrayList<Movie>, var myDeleteBtnClick: MyDeleteBtnClick) : RecyclerView.Adapter<MyMovieAdapter.MyMovieHolder>() {

    inner class MyMovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun onBind(movie: Movie){
            itemView.name_movie.text = movie.movie_name
            itemView.about_movie.text = movie.movie_authors
            itemView.date.text = movie.movie_date

            itemView.edit_btn.setOnClickListener {
                val intent = Intent(context,EditActivity::class.java)
                intent.putExtra("name","${itemView.name_movie.text}")
                intent.putExtra("author","${itemView.about_movie.text}")
                intent.putExtra("date","${itemView.date.text}")
                intent.putExtra("about","${movieList[movieList.indexOf(movie)].about_movie}")
                context.startActivity(intent)
            }
            itemView.delete_btn.setOnClickListener {
                myDeleteBtnClick.deleteBtnClick(movie)
            }
            itemView.setOnClickListener {
                val intent = Intent(context,Avangers::class.java)
                intent.putExtra("name","${itemView.name_movie.text}")
                intent.putExtra("about","${movieList[movieList.indexOf(movie)].about_movie}")
                intent.putExtra("author","${itemView.about_movie.text}")
                intent.putExtra("date","${itemView.date.text}")
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyMovieHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_layput, parent, false)
        return MyMovieHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyMovieHolder, position: Int) {
        val movie : Movie = movieList[position]
        holder.onBind(movie)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
    interface MyDeleteBtnClick{
        fun deleteBtnClick(movie: Movie)
    }
}