package com.keepcoding.appfinal.presentation.detail

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.keepcoding.appfinal.R
import com.keepcoding.appfinal.components.ShowError
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieDetailScreen(
    id: Int,
    movieDetailViewModel: MovieDetailViewModel = koinViewModel(),
    onBack: () -> Unit
) {
    val movieState = movieDetailViewModel.movie.observeAsState()
    val errorState = movieDetailViewModel.errorMessage.observeAsState()
    //Log.d("PELICULA", id.toString())
    movieDetailViewModel.getMovie(id)

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }
    val result = movieState.value

    result?.let { movie ->
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = colorResource(id = R.color.colorPpalBlue),
                    title = {
                        Text(
                            text = movie.title,
                            color = Color.White,
                            fontSize = 15.sp
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            modifier = Modifier
                                .semantics {
                                    contentDescription = "Back to movies list"
                                },
                            onClick = onBack,
                        ) {
                            Icon(
                                Icons.Filled.ArrowBack,
                                "Back",
                                tint = Color.White
                            )
                        }
                    }
                )
            }
        ) {
            ShowMovieDetail(movie = movie)
        }
    }
}

