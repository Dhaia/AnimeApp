package com.example.animeapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.animeapp.R
import com.example.animeapp.presentation.utils.NavigationScreens
import com.example.animeapp.presentation.utils.cornersShape
import com.example.animeapp.ui.theme.QuiqkSand
import compose.icons.EvaIcons
import compose.icons.evaicons.Outline
import compose.icons.evaicons.outline.Search

@Composable
fun TopAppBar(state: Boolean, setState: (Boolean) -> Unit, navController: NavHostController,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, end = 10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .fillMaxWidth(0.56f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(R.string.ani_top_app_bar_title),
                    fontSize = 15.sp,
                    fontFamily = QuiqkSand,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.list_top_app_bar_title),
                    fontSize = 15.sp,
                    fontFamily = QuiqkSand,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onSurface.copy(0.5f)
                )
            }
            IconButton(
                onClick = { setState(!state)
                          navController.navigate(NavigationScreens.SearchScreen.routeWithArguments)},
            ) {
                Icon(
                    imageVector = EvaIcons.Outline.Search,
                    contentDescription = stringResource(R.string.search),
                )
            }
        }
    }
}

@Composable
fun PagerItem(modifier: Modifier) {

    val isSystemDarkTheme = isSystemInDarkTheme()
    // White/Black Gradient on top of images
    val shadowGradient = Brush.verticalGradient(
        colors = listOf(
            Color.Transparent,
            Color.White.copy(0.2f)
        )
    )

    Box(
        modifier = modifier
    ) {

        BottomPart(
            shadowGradient,
            Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(140.dp)
                .clip(RoundedCornerShape(cornersShape))
        )

        // Big Image at top
        Surface(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(5.dp)
                .fillMaxWidth(0.92f)
                .height(170.dp),
            elevation = 15.dp,
            shape = RoundedCornerShape(cornersShape)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.fate_zero_image)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                placeholder = painterResource(id = R.drawable.fate_zero_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(cornersShape))
                    .fillMaxSize()
            )
            // White/Black shadow at bottom
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .background(
                        shadowGradient
                    )
                    .align(Alignment.BottomCenter)
            )
        }

    }
}

@Composable
private fun BottomPart(shadowGradient: Brush, modifier: Modifier) {
    Surface(
        modifier = modifier,
        elevation = 9.dp,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.surface)
                .padding(bottom = 10.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.84f),
                verticalAlignment = Alignment.CenterVertically
            ) {

                SmallImage(
                    shadowGradient = shadowGradient,
                    modifier = Modifier
                        .width(61.dp)
                        .height(60.dp)
                        .padding(5.dp)
                )
                Spacer(modifier = Modifier.padding(5.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column {
                        Text(
                            text = stringResource(R.string.fate_stay_night),
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = QuiqkSand
                        )
                        Spacer(modifier = Modifier.padding(1.dp))
                        Text(
                            text = stringResource(R.string.tv_show_13_episodes),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colors.onSurface.copy(0.4f),
                            fontFamily = QuiqkSand
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = stringResource(R.string.score),
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colors.onSurface.copy(0.45f)
                        )
                        Spacer(modifier = Modifier.padding(2.dp))

                        Score("8.3")
                    }
                }

            }
        }
    }
}

@Composable
private fun SmallImage(
    shadowGradient: Brush,
    modifier: Modifier
) {
    Surface(
        modifier = modifier,
        elevation = 5.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.fate_zero_image_2)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                placeholder = painterResource(id = R.drawable.fate_zero_image_2),
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(RoundedCornerShape(5.dp))
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(
                        shadowGradient
                    )
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
private fun Score(score: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFBD00FF),
                        Color(0xFF8C12CE),
                    )
                )
            )
            .padding(horizontal = 9.dp, vertical = 2.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = score,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun ListItem(index: Int) {
    Box(modifier = Modifier
        .width(140.dp)
        .clip(RoundedCornerShape(10.dp))
        .clickable { }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(
                            if (index == 0)
                                R.drawable.wallpaper_one
                            else if (index == 1)
                                R.drawable.wallpaper_two
                            else R.drawable.wallpaper_three

                        )
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    placeholder = painterResource(id = R.drawable.wallpaper_one),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
                val shadowGradient = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.White.copy(0.3f)
                    )
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .background(
                            shadowGradient
                        )
                        .align(Alignment.BottomCenter)
                )
            }
            Text(
                text = stringResource(R.string.demon_slayer),
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(top = 6.dp),
                color = MaterialTheme.colors.onBackground.copy(0.75f)
            )
            Spacer(modifier = Modifier.padding(3.dp))
            Text(
                text = stringResource(R.string.tv_show_airing_in_21_days),
                fontSize = 11.sp,
                color = MaterialTheme.colors.onBackground.copy(0.55f),
                textAlign = TextAlign.Center
            )
        }
    }
}
