package com.example.gamesstore.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.gamesstore.domain.models.Game
import com.example.gamesstore.presentation.theme.Gilory
import com.example.gamesstore.presentation.util.NavigationScreens

@Composable
fun GameListItem(game: Game, navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .clickable { navController.navigate(NavigationScreens.DetailScreen.route) },
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = rememberImagePainter(
                game.images[0],
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .height(240.dp),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 16.dp, end = 16.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(game.color)
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Image(
                        painter = rememberImagePainter(
                            game.images[0],
                            builder = {
                                crossfade(true)
                            }
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.padding(10.dp))

                Column {
                    Text(
                        text = game.title,
                        fontSize = 15.sp,
                        style = TextStyle(
                            fontFamily = Gilory,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    Text(
                        text = game.description,
                        fontSize = 13.sp,
                        style = TextStyle(
                            fontFamily = Gilory,
                            fontWeight = FontWeight.Normal,
                            color = Color.White.copy(0.7f),
                            lineHeight = 15.sp
                        )
                    )
                }
            }
        }

    }
}