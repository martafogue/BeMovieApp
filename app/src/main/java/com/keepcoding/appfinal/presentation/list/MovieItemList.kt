package com.keepcoding.appfinal.presentation.list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.keepcoding.appfinal.domain.MovieModel
import com.keepcoding.appfinal.presentation.detail.AndroidViewShop
import com.keepcoding.appfinal.presentation.theme.globalElevation
import com.keepcoding.appfinal.presentation.theme.globalPadding
import com.keepcoding.appfinal.presentation.theme.globalRoundedCornerShape

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    movie: MovieModel,
    onClick: (() -> Unit)? = null
) {
    var isSelected by rememberSaveable() {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier.padding(globalPadding),
        border = BorderStroke(2.dp, Color(red = 50, green = 83, blue = 203)),
        elevation = globalElevation,
        shape = RoundedCornerShape(globalRoundedCornerShape)
    ) {

        Column() {
            Box(
                modifier = Modifier
                    .height(260.dp)
                    .clickable {
                        onClick?.invoke()
                    }
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://image.tmdb.org/t/p/w200${movie.poster_path}")
                        .crossfade(true)
                        .build(),
                    contentDescription = "poster movie",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "icon back",
                    modifier = Modifier
                        .size(85.dp)
                        .offset(5.dp, 5.dp),
                    tint = Color(0, 0, 0, 80)
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "icon front",
                    modifier = Modifier.size(85.dp), tint = Color.White,
                    //tint = Color.White
                )
                AndroidViewFavorite()
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(10.dp, 15.dp, 15.dp, 15.dp),
                //contentAlignment = Alignment.CenterStart
            ){

                Row() {
                    AndroidViewShop()

                    Text(
                        text = movie.title,
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 16.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        lineHeight = 14.sp,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                    )
                }
            }
        }
    }
}