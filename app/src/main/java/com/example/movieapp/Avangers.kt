package com.example.movieapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_avangers.*
import kotlinx.android.synthetic.main.activity_edit.*

class Avangers : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avangers)

        val name = intent.getStringExtra("name")
        supportActionBar?.title = name
        val authors = intent.getStringExtra("author")
        val about = intent.getStringExtra("about")
        val date = intent.getStringExtra("date")
        showName.text = "Movie name: $name"
        showAuthors.text = "Movie authors: $authors"
        showAbout.text = "About movie: $about"
        showDate.text = "Date: $date"

        closeBtn.setOnClickListener {
           finish()
        }
    }
}