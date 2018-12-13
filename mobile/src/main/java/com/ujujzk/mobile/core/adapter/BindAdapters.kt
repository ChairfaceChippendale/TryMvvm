package com.ujujzk.mobile.core.adapter

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.ujujzk.mobile.core.util.DrawableUtil

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?){
    DrawableUtil.loadImage(imageView, url)
}