package com.keepcoding.appfinal.presentation.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.keepcoding.appfinal.components.FavoriteComponent

@Composable
fun AndroidViewFavorite(){

    var isSelected by rememberSaveable() {
        mutableStateOf(false)
    }
    AndroidView(
        modifier =
        Modifier
            .padding(120.dp, 0.dp, 0.dp, 210.dp)
            .clickable {
                val newState = !isSelected
                isSelected = newState
            },
        factory = { context ->
            FavoriteComponent(context).apply {
                this.checked = isSelected
            }
        },
        update = {
            it.checked = isSelected
        }
    )
}