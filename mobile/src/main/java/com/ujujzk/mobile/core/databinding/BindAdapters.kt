package com.ujujzk.mobile.core.databinding

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.ujujzk.mobile.core.util.DrawableUtil

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?){
    DrawableUtil.loadImage(imageView, url)
}

