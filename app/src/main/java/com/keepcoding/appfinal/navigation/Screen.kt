package com.keepcoding.appfinal.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
) {

    object InitialScreen : Screen(
        route = "initial",
        arguments = emptyList()
    )

    object MovieListScreen : Screen(
        route = "movieList",
        arguments = emptyList()
    )

    object MovieDetailScreen : Screen(
        route = "movieDetail",
        arguments = listOf(
            navArgument("movieId") {
                type = NavType.IntType
                nullable = false
            }
        )
    )
}
