package com.konkuk.codion.ui.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.konkuk.codion.ui.home.HomeScreen
import com.konkuk.codion.ui.navigation.MainTabRoute

fun NavController.navigateToHome(navOptions: NavOptions) {
    navigate(MainTabRoute.Home, navOptions)
}

fun NavGraphBuilder.homeNavGraph() {
    composable<MainTabRoute.Home> {
        HomeScreen()
    }
}