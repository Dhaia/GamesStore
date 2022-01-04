package com.example.gamesstore.presentation.util

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.gamesstore.presentation.detail.DetailScreen
import com.example.gamesstore.presentation.games.GamesScreen
import com.example.gamesstore.presentation.home.HomeScreen
import com.example.gamesstore.presentation.options.OptionsScreen
import com.example.gamesstore.presentation.search.SearchScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun Navigation(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier
) {

    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(NavigationScreens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(NavigationScreens.DetailScreen.route) {
            DetailScreen(navController)
        }

        composable(NavigationScreens.GamesScreen.route) {
            GamesScreen()
        }

        composable(NavigationScreens.SearchScreen.route) {
            SearchScreen()
        }

        composable(NavigationScreens.OptionsScreen.route) {
            OptionsScreen()
        }
    }
}