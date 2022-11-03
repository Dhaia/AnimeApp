package com.example.animeapp.presentation.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import compose.icons.EvaIcons
import compose.icons.evaicons.Outline
import compose.icons.evaicons.outline.ArrowIosBack
import kotlinx.coroutines.delay

@Composable
fun SearchScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colors.surface,
                shape = RoundedCornerShape(
                    topEnd = 0.dp, topStart = 0.dp,
                    bottomStart = 0.dp, bottomEnd = 0.dp
                )
            )
            .padding(16.dp),
    ) {
        // TODO when also navigating back, do an exit animation
        val state = remember {
            mutableStateOf(false)
        }
        LaunchedEffect(key1 = false) {
            delay(10)
            state.value = true
        }

        Column(modifier = Modifier.fillMaxSize()) {
            AnimatedVisibility(
                visible = state.value,
                enter = fadeIn(
                    animationSpec = tween(durationMillis = 2000)
                ) + slideInVertically(
                    animationSpec = tween(durationMillis = 2000)
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Search",
                        color = MaterialTheme.colors.onBackground.copy(0.65f),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    Text(
                        text = "for anime",
                        color = MaterialTheme.colors.onBackground.copy(0.4f),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            TextField(
                value = "", onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
                placeholder = {
                    Text(
                        text = "Type here",
                        color = MaterialTheme.colors.onSurface.copy(0.25f)
//                        fontSize = 13.sp
                    )
                }
            )
        }

//        IconButton(
//            onClick = { /*TODO*/ },
//            modifier = Modifier.align(Alignment.BottomStart)
//        ) {
//            Icon(
//                EvaIcons.Outline.ArrowIosBack, contentDescription = "",
//                tint = MaterialTheme.colors.onSurface.copy(0.4f),
//                modifier = Modifier.size(32.dp)
//            )
//        }
    }
}

@Composable
fun RevealAnimation() {
    val animateShape = remember { Animatable(28f) }
    LaunchedEffect(animateShape) {
        animateShape.animateTo(
            targetValue = 2f,
            animationSpec = repeatable(
                animation = tween(
                    durationMillis = 2000,
                    easing = LinearEasing,
                    delayMillis = 500
                ),
                repeatMode = RepeatMode.Restart,
                iterations = 3
            )
        )
    }

    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(color = Color(0xFF302522))
            .border(
                width = Dp(animateShape.value),
                color = Color(0xFFede0dc),
                shape = CircleShape
            )
    ) {
//        AsyncImage(
//            model = painterResource(id = R.drawable.wallpaper_one),
//            contentDescription = "Compose image",
//            modifier = Modifier
//                .size(56.dp)
//                .align(alignment = Alignment.Center)
//        )
    }
}