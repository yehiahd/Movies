package com.yehiahd.movies.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso


@BindingAdapter(value = ["android:loadImage"])
fun loadImage(view: ImageView, imgUrl: String) {
    Picasso.get()
            .load(imgUrl)
            .into(view)
}
