package com.ujujzk.mobile.core.util

import android.util.Log
import android.widget.ImageView
import com.squareup.picasso.Picasso

class DrawableUtil {

    companion object {

        fun loadImage(target: ImageView, imageUrl: String?){
            if (imageUrl.orEmpty().isEmpty()){
                return
            }
            Picasso.get()
                    .load(imageUrl)
                    .fit()
                    .into(target)
        }
    }
}