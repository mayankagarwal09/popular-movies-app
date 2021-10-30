package com.example.popularmovies.repository

import com.example.popularmovies.api.MovieService
import com.example.popularmovies.models.Movie
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieService: MovieService
) {
    suspend fun loadMovies(apiKey: String): List<Movie> {
        return movieService.loadMovies(apiKey).results
    }
}