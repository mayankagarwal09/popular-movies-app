package com.example.popularmovies.viewModels

import android.util.Base64
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.popularmovies.di.modules.NetworkModule
import com.example.popularmovies.models.Movie
import com.example.popularmovies.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val movieRepository: MovieRepository
) : ViewModel() {

    private val _movieList = MutableLiveData<List<Movie>?>()

    val movieList: LiveData<List<Movie>?>
        get() = _movieList

    external fun getApiKey(): String

    init {
        System.loadLibrary("native-lib")
        NetworkModule.API_KEY =
            String(Base64.decode(getApiKey(), Base64.DEFAULT), Charsets.UTF_8)
    }

    fun loadMovieList() {
        viewModelScope.launch {
            val response = movieRepository.loadMovies(NetworkModule.API_KEY)
            Log.d(javaClass.simpleName, "response: $response")
            _movieList.value = response
        }
    }

}