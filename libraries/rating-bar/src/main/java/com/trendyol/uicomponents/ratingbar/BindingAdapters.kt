package com.trendyol.uicomponents.ratingbar

import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("tintCompat")
internal fun ImageView.setTintCompat(@ColorInt tint: Int) {
    drawable.mutate()
    DrawableCompat.setTint(drawable, tint)
}

@BindingAdapter("starDrawable")
internal fun AppCompatImageView.setStarDrawable(@DrawableRes drawableResId: Int) {
    setImageResource(drawableResId)
}
