package com.keepcoding.appfinal.components

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import com.keepcoding.appfinal.R

class ShopComponent @JvmOverloads constructor(
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
        imageView = inflate(context, R.layout.component_shop, this)
            .findViewById(R.id.iv_shop)
    }

    private fun selectImage() = imageView.setImageResource(
        if (checked) {
            R.drawable.carrito_lleno_24
        } else {
            R.drawable.carrito_llenar_24_bn
        }
    )
}