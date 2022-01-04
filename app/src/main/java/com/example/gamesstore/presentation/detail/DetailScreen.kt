package com.example.gamesstore.presentation.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.gamesstore.R
import com.example.gamesstore.domain.models.Game
import com.example.gamesstore.presentation.MainViewModel
import com.example.gamesstore.presentation.theme.Gilory
import com.example.gamesstore.presentation.theme.darkBlue
import com.example.gamesstore.presentation.theme.darkGrey
import com.example.gamesstore.presentation.theme.lightBlue
import com.gowtham.ratingbar.RatingBar

@ExperimentalFoundationApi
@Composable
fun DetailScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()) {
    Content(navController, mainViewModel)
}

@ExperimentalFoundationApi
@Composable
fun Content(navController: NavController, mainViewModel: MainViewModel) {

    val game = mainViewModel.gamesList[0]

    BoxWithConstraints() {

        val boxWithConstraintsScope = this

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(darkGrey)
        ) {

            item {
                GameImageSection(boxWithConstraintsScope, game)
            }

            item {
                GameDetailsSectionOne(game)
            }

            item {
                GameDetailsSectionTwo(game)
            }

            item {
                GameImagesSection(game)
            }

            item {
                GameStorySection(game)
            }
        }

        AppBar(navController)
    }

}

@Composable
fun AppBar(navController: NavController) {
    Row(modifier = Modifier.padding(start = 10.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)){
        IconButton(onClick = { navController.navigateUp() }) {
            Icon(Icons.Filled.ArrowBack,
                contentDescription = stringResource(R.string.back),
            tint = Color.White)
        }
    }
}

@Composable
fun GameImageSection(boxWithConstraintsScope: BoxWithConstraintsScope, game: Game) {
    Image(
        painter = rememberImagePainter(
            game.images[0],
            builder = {
                crossfade(true)
            }
        ),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(boxWithConstraintsScope.maxHeight * .45f)
            .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)),
        contentScale = ContentScale.Crop
    )

    //Spacer(modifier = Modifier.padding(15.dp))
}

@Composable
fun GameDetailsSectionOne(game: Game) {

    Spacer(modifier = Modifier.padding(5.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Surface(elevation = 8.dp, shape = RoundedCornerShape(10)) {
            Image(
                painter = rememberImagePainter(
                    game.images[0],
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(65.dp)
                    .clip(RoundedCornerShape(10)),
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

@Composable
fun GameDetailsSectionTwo(game: Game) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            //.padding(16.dp)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RatingBar(
                onValueChange = {},
                onRatingChanged = {},
                value = game.rating,
                inactiveColor = darkBlue.copy(0.4F),
                size = 12.dp,
                activeColor = lightBlue,
            )
            Spacer(modifier = Modifier.padding(2.dp))

            Text(
                text = "${game.rating}",
                fontSize = 12.sp,
                style = TextStyle(
                    fontFamily = Gilory,
                    fontWeight = FontWeight.Normal,
                )
            )
        }

        Text(
            text = game.genre,
            fontSize = 12.sp,
            style = TextStyle(
                fontFamily = Gilory,
                fontWeight = FontWeight.Normal,
            )
        )

        Text(
            text = game.age_requirement,
            fontSize = 12.sp,
            style = TextStyle(
                fontFamily = Gilory,
                fontWeight = FontWeight.Normal,
            )
        )

        Text(
            text = "Game of the day",
            fontSize = 12.sp,
            style = TextStyle(
                fontFamily = Gilory,
                fontWeight = FontWeight.Normal,
            )
        )
    }

    //Spacer(modifier = Modifier.padding(15.dp))
}

@Composable
fun GameImagesSection(game: Game) {

    Spacer(modifier = Modifier.padding(5.dp))

        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, bottom = 16.dp, top = 16.dp),
        ){
            items(game.images){ image ->
                Surface(elevation = 8.dp, shape = RoundedCornerShape(10)) {
                    Image(
                        painter = rememberImagePainter(
                            image,
                            builder = {
                                crossfade(true)
                            }
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .width(260.dp)
                            .height(170.dp)
                            .clip(RoundedCornerShape(8)),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.padding(10.dp))
            }
        }
}

@Composable
fun GameStorySection(game: Game) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = game.story,
            fontSize = 14.sp,
            style = TextStyle(
                fontFamily = Gilory,
                fontWeight = FontWeight.Medium,
                //color = Color.White.copy(0.8f),
                lineHeight = 20.sp
            )
        )
    }
}