package com.keepcoding.appfinal.presentation.list

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.keepcoding.appfinal.components.ShowError
import com.keepcoding.appfinal.presentation.tab.TabScreen
import com.keepcoding.appfinal.presentation.user.UserScreen
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieListScreen(
    movieListViewModel: MovieListViewModel = koinViewModel(),
    onItemClick: (Int) -> Unit
){
    val state = movieListViewModel.movieList.observeAsState()
    val errorState = movieListViewModel.errorMessage.observeAsState()

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
    ShowError(error = error ?: "")
    }

    TabScreen(

        pantalla1 =
            {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(150.dp),
                    contentPadding = PaddingValues(8.dp),
                    modifier = Modifier
                        .background(Color.White)
                ) {

                    val movieList = state.value ?: emptyList()

                    items(movieList.size){
                        val movie = movieList[it]
                        Log.d("PELICULA", movie.toString())

                        MovieItem(Modifier.padding(2.dp), movie){
                            Log.d("PELICULA", movie.id.toString())
                            onItemClick.invoke(movie.id)
                        }
                    }
                }
            },

        pantalla2 =
            {
                UserScreen()
            },
    )
}

