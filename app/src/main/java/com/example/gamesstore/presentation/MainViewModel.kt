package com.example.gamesstore.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.gamesstore.R
import com.example.gamesstore.domain.models.Game
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
) : ViewModel() {

    private val game1Color = Color(0xFF824571)
    private val game2Color = Color(0xFF5f556d)

    val gamesList = mutableStateListOf(
        Game(
            title = "Alto's Odyssey",
            color = game1Color,
            images = listOf(
                R.drawable.alto_1,
                R.drawable.detail_pics_1,
                R.drawable.detail_pics_2,
                R.drawable.detail_pics_3,
            ),
            description = "Just beyond the horizon sits a majestic desert, vast and unexplored.",
            genre = "Action",
            age_requirement = "9+",
            story = "Join Alto and his friends and set off on an endless sandboarding journey to discover its secrets.\n" +
                    "Soar above windswept dunes, traverse thrilling canyons, and explore long-hidden temples in a fantastical place far from home.\n" +
                    "Along the way, you’ll grind across vines, bounce atop hot air balloons, ride towering rock walls, and escape mischievous lemurs – all while uncovering the desert’s many mysteries."
        ),
        Game(
            title = "Adventure Journey",
            color = game2Color,
            images = listOf(
                R.drawable.adventure_game_1,
                R.drawable.detail_pics_1,
                R.drawable.detail_pics_2,
                R.drawable.detail_pics_3,
            ),
            description = "Just beyond the horizon sits a majestic desert, vast and unexplored.",
            genre = "Action",
            age_requirement = "9+",
            story = "Join Alto and his friends and set off on an endless sandboarding journey to discover its secrets.\n" +
                    "Soar above windswept dunes, traverse thrilling canyons, and explore long-hidden temples in a fantastical place far from home.\n" +
                    "Along the way, you’ll grind across vines, bounce atop hot air balloons, ride towering rock walls, and escape mischievous lemurs – all while uncovering the desert’s many mysteries."
        ),
        Game(
            title = "Alto's Odyssey",
            color = game1Color,
            images = listOf(
                R.drawable.alto_1,
                R.drawable.detail_pics_1,
                R.drawable.detail_pics_2,
                R.drawable.detail_pics_3,
            ),
            description = "Just beyond the horizon sits a majestic desert, vast and unexplored.",
            genre = "Action",
            age_requirement = "9+",
            story = "Join Alto and his friends and set off on an endless sandboarding journey to discover its secrets.\n" +
                    "Soar above windswept dunes, traverse thrilling canyons, and explore long-hidden temples in a fantastical place far from home.\n" +
                    "Along the way, you’ll grind across vines, bounce atop hot air balloons, ride towering rock walls, and escape mischievous lemurs – all while uncovering the desert’s many mysteries."
        ),
        Game(
            title = "Adventure Journey",
            color = game2Color,
            images = listOf(
                R.drawable.adventure_game_1,
                R.drawable.detail_pics_1,
                R.drawable.detail_pics_2,
                R.drawable.detail_pics_3,
            ),
            description = "Just beyond the horizon sits a majestic desert, vast and unexplored.",
            genre = "Action",
            age_requirement = "9+",
            story = "Join Alto and his friends and set off on an endless sandboarding journey to discover its secrets.\n" +
                    "\n" +
                    "Soar above windswept dunes, traverse thrilling canyons, and explore long-hidden temples in a fantastical place far from home.\n" +
                    "\n" +
                    "Along the way, you’ll grind across vines, bounce atop hot air balloons, ride towering rock walls, and escape mischievous lemurs – all while uncovering the desert’s many mysteries."
        ),
    )

}
