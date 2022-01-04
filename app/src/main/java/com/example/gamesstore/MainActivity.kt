package com.example.gamesstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gamesstore.presentation.components.BottomBar
import com.example.gamesstore.presentation.theme.GamesStoreTheme
import com.example.gamesstore.presentation.util.Navigation
import com.example.gamesstore.presentation.util.NavigationScreens
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalFoundationApi::class,
    ExperimentalAnimationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamesStoreTheme {
                MainScreen()
            }
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun MainScreen() {
    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination: NavDestination? = navBackStackEntry?.destination

    val startDestination = NavigationScreens.HomeScreen.route

    val hideComponents = currentDestination?.route == NavigationScreens.DetailScreen.route

    Scaffold(
        bottomBar = {
            if(!hideComponents)
                BottomBar(
                    navController = navController, currentRoute = currentDestination?.route
                )
        }
    ) { innerPadding ->
        Navigation(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
