package com.example.movieapp

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*
import kotlin.collections.ArrayList

class LocalData(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()
    private val gson = Gson()
    private val list = ArrayList<Movie>()
    private var stringData = ""
    fun saveData(data: Movie) {
        list.clear()
        list.addAll(getList())
        data.id = list.size
        list.add(data)
        stringData = gson.toJson(list)
        editor.putString("movieList", stringData).commit()
    }
    fun getList(): List<Movie> {
        return if (!sharedPreferences.getString("movieList", "").isNullOrBlank()) {
            val type = object : TypeToken<List<Movie>>() {}.type
            val stringListData = sharedPreferences.getString("movieList", "")
                gson.fromJson(stringListData, type)
        } else listOf()
    }

    fun editor(data: Movie){
        list.clear()
        list.addAll(getList())
        list[data.id] = data
        stringData = gson.toJson(list)
        editor.putString("movieList", stringData).commit()
    }
    fun delete(data: Movie){
        list.clear()
        list.addAll(getList())
        val index = list.indexOfFirst { it.movie_name == data.movie_name }
        list.removeAt(index)
        stringData = gson.toJson(list)
        editor.putString("movieList", stringData).commit()
    }
}