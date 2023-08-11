package com.keepcoding.appfinal.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.InitialScreen.route,
    ) {
        //addTabScreen(navController)
        addInitialScreen(navController)
        addMovieListScreen(navController)
        addMovieDetailScreen(navController)
    }
}
