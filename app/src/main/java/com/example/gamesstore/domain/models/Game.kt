package com.example.gamesstore.domain.models

import androidx.compose.ui.graphics.Color

data class Game(
    val title: String,
    val images: List<Int>,
    val description: String,
    val story: String,
    val rating: Float = 4f,
    val genre: String,
    val age_requirement: String,
    val color: Color,
)