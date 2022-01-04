package com.example.gamesstore.presentation.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Games
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationScreens(
    var route: String, var icon: ImageVector?, var title: String
) {

    object HomeScreen : NavigationScreens(
        route = "HomeScreen",
        icon = Icons.Filled.Home,
        title = "HomeScreen"
    )

    object GamesScreen : NavigationScreens(
        route = "GamesScreen",
        icon = Icons.Filled.Games,
        title = "GamesScreen"
    )

    object SearchScreen : NavigationScreens(
        route = "SearchScreen",
        icon = Icons.Filled.Search,
        title = "SearchScreen"
    )

    object OptionsScreen : NavigationScreens(
        route = "OptionsScreen",
        icon = Icons.Filled.Menu,
        title = "OptionsScreen"
    )

    object DetailScreen : NavigationScreens(
        route = "DetailScreen",
        icon = Icons.Filled.Menu,
        title = "DetailScreen"
    )
}
