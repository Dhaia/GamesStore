package com.example.gamesstore.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.gamesstore.R
import com.example.gamesstore.presentation.MainViewModel
import com.example.gamesstore.presentation.components.GameListItem
import com.example.gamesstore.presentation.theme.Gilory
import com.example.gamesstore.presentation.theme.darkBlue
import com.example.gamesstore.presentation.theme.darkGrey
import com.example.gamesstore.presentation.theme.lightBlue


@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
    navController: NavController
) {
    Content(mainViewModel, navController)
}

@ExperimentalFoundationApi
@Composable
fun Content(
    mainViewModel: MainViewModel,
    navController: NavController
) {

    Surface(color = darkGrey) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {

            item {
                HelloSection()
            }

            stickyHeader {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(darkGrey)
                        .padding(top = 6.dp, bottom = 8.dp)
                ) {
                    TabSection()
                }
            }

            item {
                Spacer(modifier = Modifier.height(15.dp))
            }

            items(mainViewModel.gamesList) { game ->
                GameListItem(game, navController)
                Spacer(modifier = Modifier.height(35.dp))
            }
        }
    }
}

@Composable
fun HelloSection() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            )
            {
                Text(
                    text = "Hello",
                    fontSize = 24.sp, style = TextStyle(
                        fontFamily = Gilory,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                )

                Spacer(modifier = Modifier.padding(2.dp))

                Text(
                    text = "Lisa,",
                    fontSize = 24.sp, style = TextStyle(
                        fontFamily = Gilory,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Best games for today",
                fontSize = 24.sp, style = TextStyle(
                    fontFamily = Gilory,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        }

        Image(
            painter = rememberImagePainter(
                R.drawable.profile_pic,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .size(43.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun TabSection() {

    Spacer(modifier = Modifier.height(15.dp))

    val tabList = listOf(
        "Action",
        "Adventure",
        "Board",
        "Card",
        "Casino",
        "RPG"
    )
    val (selectedTabIndex, setTabIndex) = remember {
        mutableStateOf(0)
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        itemsIndexed(tabList) { index, text ->

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                    setTabIndex(index)
                }
            ) {
                Text(
                    text,
                    color = if (index == selectedTabIndex) lightBlue
                    else Color.White.copy(0.4f),
                    fontWeight = if (index == selectedTabIndex) FontWeight.Bold
                    else FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(3.dp))

                if (index == selectedTabIndex) {
                    Divider(
                        modifier = Modifier
                            .size(5.dp)
                            .clip(CircleShape),
                        color = darkBlue
                    )
                }
            }
            Spacer(modifier = Modifier.padding(15.dp))
        }
    }
}