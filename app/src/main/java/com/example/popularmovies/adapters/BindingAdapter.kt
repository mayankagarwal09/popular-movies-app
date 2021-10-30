package com.example.popularmovies.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation


@BindingAdapter("imageUrl")
fun setImageUrl(view: ImageView, posterPath: String) {
    Picasso.get().load("https://image.tmdb.org/t/p/w500$posterPath")
        .transform(RoundedCornersTransformation(40, 5))
        .into(view)
}