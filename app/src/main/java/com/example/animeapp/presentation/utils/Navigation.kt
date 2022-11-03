package com.example.animeapp.presentation.utils

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavHostController
import com.example.animeapp.presentation.home.HomeScreen
import com.example.animeapp.presentation.search.SearchScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import kotlin.math.roundToInt

val durationMillis = 350

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier,
    scaffoldState: ScaffoldState,
) {


    val mainExitTransition =
//        slideOutHorizontally(
//        targetOffsetX = { -durationMillis },
//        animationSpec = tween(
//            durationMillis = durationMillis,
//            easing = FastOutSlowInEasing
//        )
//    ) +
        fadeOut(animationSpec = tween(300))
    val mainEnterTransition =
//        slideInHorizontally(
//        initialOffsetX = { -durationMillis },
//        animationSpec = tween(
//            durationMillis = durationMillis,
//            easing = FastOutSlowInEasing
//        )
//    )
        fadeIn(animationSpec = tween(durationMillis))

    val detailEnterTransition = slideInHorizontally(
        initialOffsetX = { durationMillis },
        animationSpec = tween(
            durationMillis = durationMillis,
            easing = FastOutSlowInEasing
        )
    ) + fadeIn(animationSpec = tween(durationMillis))
    val detailExitTransition = slideOutHorizontally(
        targetOffsetX = { durationMillis },
        animationSpec = tween(
            durationMillis = durationMillis,
            easing = FastOutSlowInEasing
        )
    ) + fadeOut(animationSpec = tween(durationMillis))

    AnimatedNavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(
            NavigationScreens.HomeScreen.routeWithArguments,
            popExitTransition = {
                mainExitTransition
            },
            exitTransition = {
                mainExitTransition
            },
            popEnterTransition = {
                mainEnterTransition
            },
            enterTransition = {
                mainEnterTransition
            }
        ) {
            HomeScreen(
                navController = navController,
            )
        }

        composable(
            NavigationScreens.SearchScreen.routeWithArguments,
            enterTransition = {
                slideIn(
                    initialOffset = { IntOffset(it.width * 2, -it.height) },
                    animationSpec = tween(durationMillis = 950)
                )
            },
            exitTransition = {
                slideOut(
                    animationSpec = tween(durationMillis = 600),
                    targetOffset = { IntOffset(it.width*2, -it.height) }
                )
            }
        ) {
            SearchScreen(navController)
        }
    }
}