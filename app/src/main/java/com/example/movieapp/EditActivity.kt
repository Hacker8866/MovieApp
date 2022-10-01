package com.example.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_save.*

class EditActivity : AppCompatActivity() {
    private lateinit var localData : LocalData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        supportActionBar?.title = "Edit movie"

        val name = intent.getStringExtra("name")
        val about = intent.getStringExtra("about")
        val date = intent.getStringExtra("date")
        val authors = intent.getStringExtra("author")
        edit_name.setText(name)
        edit_about.setText(about)
        edit_date.setText(date)
        edit_authors.setText(authors)
        localData = LocalData(this)
        edit_btn1.setOnClickListener {
            if (!edit_name.text.isNullOrEmpty()){
                val nameM = edit_name.text
                val aboutM = edit_about.text
                val authorsM = edit_authors.text
                val dateM = edit_date.text
                val movie = Movie(nameM.toString(), authorsM.toString(), aboutM.toString(), dateM.toString())
                localData.editor(movie)
                finish()
            }else{
                Toast.makeText(this, "Insert movie's name.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}