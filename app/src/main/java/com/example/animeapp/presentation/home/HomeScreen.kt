package com.example.animeapp.presentation.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavHostController
import com.example.animeapp.R
import com.example.animeapp.ui.theme.AnimeAppTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior
import kotlin.math.absoluteValue

@Composable
fun HomeScreen(
    navController: NavHostController,
) {
    Content(navController)
}

@Composable
fun Content(    navController: NavHostController,
) {

    val (state, setState) = rememberSaveable {
        mutableStateOf(false)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            TopAppBar(state, setState, navController)
            Spacer(modifier = Modifier.height(18.dp))
        }
        item {
            Pager(Modifier)
            Spacer(modifier = Modifier.height(50.dp))
        }
        item {
            UpcomingAnime()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalSnapperApi::class)
@Composable
fun UpcomingAnime() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.upcoming),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = stringResource(R.string.anime),
                    color = MaterialTheme.colors.onSurface.copy(0.64f)
                )
            }
            Box(modifier = Modifier.clickable { }) {
                Text(
                    text = stringResource(R.string.see_more),
                    fontSize = 13.sp, fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.onSurface.copy(0.3f)
                )
            }
        }

        val lazyListState = rememberLazyListState()
        LazyRow(
            state = lazyListState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 16.dp),
            flingBehavior = rememberSnapperFlingBehavior(lazyListState)
        ) {
            items(5) { index ->
                ListItem(index)
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Pager(modifier: Modifier = Modifier) {
    HorizontalPager(
        count = 10,
        contentPadding = PaddingValues(horizontal = 32.dp),
        modifier = modifier.fillMaxWidth()
    ) { page ->
        Box(
            Modifier
                .graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
                .fillMaxWidth()
        ) {
            Box {
                PagerItem(
                    Modifier
                        .height(260.dp)
                        .offset {
                            val pageOffset =
                                this@HorizontalPager.calculateCurrentOffsetForPage(page)
                            IntOffset(
                                x = (36.dp * pageOffset).roundToPx(),
                                y = 0
                            )
                        }
                        .clip(RoundedCornerShape(15.dp))
                        .clickable { }
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFCCCCCC
)
@Composable
fun PagerItemPreview() {
    AnimeAppTheme {
        PagerItem(Modifier)
    }
}