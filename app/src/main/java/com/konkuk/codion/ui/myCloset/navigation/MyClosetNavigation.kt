package com.konkuk.codion.ui.myCloset.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.konkuk.codion.ui.myCloset.screen.MyClosetScreen
import com.konkuk.codion.ui.navigation.MainTabRoute

fun NavController.navigateToMyCloset(navOptions: NavOptions) {
    navigate(MainTabRoute.MyCloset, navOptions)
}

fun NavGraphBuilder.myClosetNavGraph(
    padding: PaddingValues,
) {
    composable<MainTabRoute.MyCloset> {
        MyClosetScreen(
            padding = padding
        )
    }
}