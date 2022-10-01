package com.example.movieapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var localData: LocalData
    lateinit var movieList : ArrayList<Movie>
    lateinit var movieAdapter: MyMovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        localData = LocalData(this)
        add_btn.setOnClickListener {
            val intent = Intent(this, SaveActivity::class.java)
            startActivity(intent)
        }
        movieList = ArrayList()
            movieAdapter = MyMovieAdapter(this, movieList, object : MyMovieAdapter.MyDeleteBtnClick {
                @SuppressLint("NotifyDataSetChanged")
                override fun deleteBtnClick(movie: Movie) {
                    movieList.remove(movie)
                    localData.delete(movie)
                    movieAdapter.notifyItemRemoved(movieList.indexOf(movie))
                    movieAdapter.notifyDataSetChanged()
                }
            })
            recycleV.layoutManager = LinearLayoutManager(this)
            recycleV.adapter = movieAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        loadMovie()
        movieAdapter.notifyDataSetChanged()
    }

    private fun loadMovie() {

        movieList.clear()
        movieList.addAll(localData.getList())

    }
}