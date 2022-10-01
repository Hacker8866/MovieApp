package com.example.movieapp

import java.io.Serializable

class Movie : Serializable{
    var id = 0
    var movie_name: String? = ""
    var movie_authors: String? = ""
    var about_movie: String? = ""
    var movie_date: String? = ""

    constructor(movie_name: String?, movie_authors: String?, about_movie: String?, movie_date: String?) {
        this.movie_name = movie_name
        this.movie_authors = movie_authors
        this.about_movie = about_movie
        this.movie_date = movie_date
    }
}