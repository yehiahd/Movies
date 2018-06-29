package com.yehiahd.movies.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.yehiahd.movies.R


@BindingAdapter(value = ["android:loadImage"])
fun loadImage(view: ImageView, imgUrl: String) {
    Picasso.get()
            .load(imgUrl)
            .placeholder(R.drawable.imgs_placeholder)
            .error(R.drawable.imgs_error)
            .into(view)
}
