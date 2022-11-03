package com.example.animeapp.presentation.utils

sealed class NavigationScreens(
    var route: String,
    var routeWithArguments: String,
) {
    object HomeScreen : NavigationScreens(
        "HomeScreen",
        "HomeScreen"
    )

    object SearchScreen : NavigationScreens(
        "SearchScreen",
        "SearchScreen"
    )
}