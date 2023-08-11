package com.keepcoding.appfinal.presentation.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.keepcoding.appfinal.components.ShopComponent

@Composable
fun AndroidViewShop(){

    var isSelected by rememberSaveable() {
        mutableStateOf(false)
    }

    AndroidView(
        modifier = Modifier
            .padding(0.dp, 0.dp, 10.dp, 0.dp)
            .size(35.dp)
            .clickable {
                val newState = !isSelected
                isSelected = newState
            },

        factory = { context ->
            ShopComponent(context).apply {
                this.checked = isSelected
            }
        },
        update = {
            it.checked = isSelected
        }
    )
}