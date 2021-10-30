package com.example.popularmovies.api

import com.example.popularmovies.models.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("3/movie/now_playing")
    suspend fun loadMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int = 1
    ): ApiResponse
}