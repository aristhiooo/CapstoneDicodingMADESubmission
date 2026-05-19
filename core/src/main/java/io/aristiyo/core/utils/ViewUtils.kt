package io.aristiyo.core.utils

import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.ImageView
import androidx.core.graphics.toColorInt
import androidx.core.view.isVisible
import com.bumptech.glide.Glide

fun View.setColourDot(hexColour: String?) {
    if (hexColour.isNullOrBlank()) {
        isVisible = false; return
    }
    isVisible = true
    (background as? GradientDrawable)?.setColor(hexColour.toColorInt())
}

fun ImageView.loadImage(url: String?) {
    Glide.with(this.context)
        .load(url)
        .centerCrop()
        .into(this)
}