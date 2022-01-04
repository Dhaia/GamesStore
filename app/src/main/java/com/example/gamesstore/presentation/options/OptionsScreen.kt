package com.example.gamesstore.presentation.options

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.gamesstore.presentation.theme.Gilory

@Composable
fun OptionsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Options Screen",
            style = TextStyle(
                fontFamily = Gilory,
                fontWeight = FontWeight.Bold
            )
        )
    }
}