package com.example.popularmovies.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.popularmovies.adapters.MovieAdapter
import com.example.popularmovies.databinding.FragmentMovieBinding
import com.example.popularmovies.models.Movie
import com.example.popularmovies.viewModels.MainViewModel

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)

        val adapter = MovieAdapter(OnClickListener {
            findNavController().navigate(MovieFragmentDirections.actionMovieDestToMovieDetailDest(it))
        })
        binding.movieRecyclerView.adapter = adapter

        mainViewModel.movieList.observe(viewLifecycleOwner, {
            it?.let { adapter.submitList(it) }
        })

        return binding.root
    }

}

class OnClickListener(val clickListener: (movie: Movie) -> Unit) {
    fun onClick(movie: Movie) = clickListener(movie)
}