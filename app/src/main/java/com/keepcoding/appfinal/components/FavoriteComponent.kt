package com.keepcoding.appfinal.components

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import com.keepcoding.appfinal.R

class FavoriteComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val imageView: ImageView

    var checked: Boolean = false
        set(value) {
            field = value
            selectImage()
        }

    init {
        imageView = inflate(context, R.layout.component_favorite, this)
            .findViewById(R.id.iv_favorite)
    }

    private fun selectImage() = imageView.setImageResource(
        if (checked) {
            R.drawable.corazon_rojo_24
        } else {
            R.drawable.corazon_blanco_24
        }
    )
}