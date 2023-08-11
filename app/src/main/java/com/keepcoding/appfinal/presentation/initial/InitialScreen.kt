package com.keepcoding.appfinal.presentation.initial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.keepcoding.appfinal.R
import com.keepcoding.appfinal.navigation.Screen

@Composable
fun InitialScreen(navController: NavController){

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
        ){
            AsyncImage(
                model = R.drawable.bemovie,
                contentDescription = null,
                modifier = Modifier.defaultMinSize(48.dp,48.dp).fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                FloatingActionButton(
                    onClick = { navController.navigate(route = Screen.MovieListScreen.route) },
                    modifier = Modifier
                        .padding(20.dp)
                        .width(130.dp)
                        .height(50.dp),
                    contentColor = Color.Cyan,
                    containerColor = Color.Cyan,
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        modifier = Modifier
                            .size(92.dp),
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.size(100.dp))
                }
            }
        }
    }
}