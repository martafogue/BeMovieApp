package com.keepcoding.appfinal.navigation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.keepcoding.appfinal.presentation.initial.InitialScreen
import com.keepcoding.appfinal.presentation.detail.MovieDetailScreen
import com.keepcoding.appfinal.presentation.list.MovieListScreen

fun NavGraphBuilder.addInitialScreen(navController: NavController) {
    composable(Screen.InitialScreen.route) {
        InitialScreen(navController)
    }
}

fun NavGraphBuilder.addMovieListScreen(navController: NavHostController) {
    composable(Screen.MovieListScreen.route) {
        MovieListScreen { movieId ->
            navController.navigate("${Screen.MovieDetailScreen.route}/$movieId")
        }
    }
}

/*fun NavGraphBuilder.addTabScreen(navController: NavController) {
    composable(Screen.MovieListScreen.route) {
        MovieListScreen()
}*/

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.addMovieDetailScreen(navController: NavHostController) {
    composable(
        route = Screen.MovieDetailScreen.route + "/{movieId}",
        arguments = Screen.MovieDetailScreen.arguments
    ) { navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getInt("movieId") ?: 1
        MovieDetailScreen(id = id){
            navController.popBackStack()
        }
    }
}
