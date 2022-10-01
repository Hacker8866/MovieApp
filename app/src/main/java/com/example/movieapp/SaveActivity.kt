package com.example.movieapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_save.*

class SaveActivity : AppCompatActivity() {
    private lateinit var localData: LocalData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)
        supportActionBar?.title = "Add movie"
        localData = LocalData(this)
        save_btn1.setOnClickListener {
            if (!save_name.text.isNullOrBlank() &&
                !save_authors.text.isNullOrBlank() &&
                !save_about.text.isNullOrBlank() &&
                !save_date.text.isNullOrBlank()){
                val nameM = save_name.text
                val authorsM = save_authors.text
                val aboutM = save_about.text
                val dateM = save_date.text
                val movie = Movie(nameM.toString(), authorsM.toString(), aboutM.toString(), dateM.toString())
                localData.saveData(movie)
                finish()
            }else{
                Toast.makeText(this, "Please, Insert information of movie", Toast.LENGTH_SHORT).show()
            }
        }
    }
}