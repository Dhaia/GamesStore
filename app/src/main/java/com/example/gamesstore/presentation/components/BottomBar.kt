package com.example.gamesstore.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gamesstore.presentation.theme.lightBlue
import com.example.gamesstore.presentation.util.NavigationScreens

val itemsList = listOf(
    NavigationScreens.HomeScreen,
    NavigationScreens.GamesScreen,
    NavigationScreens.SearchScreen,
    NavigationScreens.OptionsScreen,
)

@Composable
fun BottomBar(
    navController: NavController,
    items: List<NavigationScreens> = itemsList,
    currentRoute: String?,
) {
    val backgroundColor = Color(0xFF3b3b3b)
    val selectedTextColor = Color.White
    val unselectedTextColor = Color.White.copy(0.7f)

    BottomAppBar(
        backgroundColor = backgroundColor,
        contentColor = MaterialTheme.colors.primary,
    ) {
        items.forEach { item ->

            BottomNavigationItem(
                icon = {
                    item.icon?.let {

                        if (currentRoute == item.route) {
                            Icon(
                                imageVector = it,
                                contentDescription = item.title,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(lightBlue)
                                    .padding(vertical = 1.dp, horizontal = 8.dp)
                            )
                        } else {
                            Icon(
                                imageVector = it,
                                contentDescription = item.title,
                            )
                        }
                    }
                },
                selectedContentColor = selectedTextColor,
                unselectedContentColor = unselectedTextColor,
                alwaysShowLabel = false,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}