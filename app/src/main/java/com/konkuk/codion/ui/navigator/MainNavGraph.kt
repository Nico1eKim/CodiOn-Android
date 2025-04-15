package com.konkuk.codion.ui.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.konkuk.codion.ui.home.HomeScreen

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Routes.Home) {
        composable<Routes.Home>{
            HomeScreen(navController = navController)
        }

        // codiRecord

        // myCloset

    }
}