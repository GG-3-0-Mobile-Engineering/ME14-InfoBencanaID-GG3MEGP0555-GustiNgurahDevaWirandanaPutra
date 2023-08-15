package com.rahdeva.bencanaapp.utils.extension

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter


fun ImageView.loadImage(img: Int){
    Glide.with(this)
        .load(img)
        .transform(FitCenter())
        .into(this)
}

fun View.makeGone(){
    this.visibility = View.GONE
}

fun View.makeVisible(){
    this.visibility = View.VISIBLE
}

fun View.makeInvisible(){
    this.visibility = View.INVISIBLE
}
