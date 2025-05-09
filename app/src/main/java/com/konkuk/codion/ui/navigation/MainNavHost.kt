package com.konkuk.codion.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.konkuk.codion.ui.codiRecord.navigation.codiRecordNavGraph
import com.konkuk.codion.ui.home.navigation.homeNavGraph
import com.konkuk.codion.ui.myCloset.navigation.myClosetNavGraph
import com.konkuk.codion.ui.onboarding.screen.LoginScreen
import com.konkuk.codion.ui.onboarding.screen.SplashScreen
import com.konkuk.codion.ui.theme.Gray100

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navigator: MainNavController,
    padding: PaddingValues
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Gray100)
    ) {
        NavHost(
            navController = navigator.navController,
            startDestination = "splash",
        ) {

            composable("splash") {
                SplashScreen {
                    navigator.navController.navigate("login") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            }

            composable("login") {
                LoginScreen {
                    navigator.navController.navigate(MainTabRoute.Home) {
                        popUpTo("login") { inclusive = true }
                    }
                }
            }

            homeNavGraph(
                padding = padding,
            )

            codiRecordNavGraph(
                padding = padding,
                navigateToAddMyClothesPicture = navigator::navigateToAddMyClothesPicture,
            )

            myClosetNavGraph(
                padding = padding,
                navigateBack = navigator::navigateUp,
                navigateToAddMyClothesPicture = navigator::navigateToAddMyClothesPicture,
            )

            // MyPage 추가
        }
    }
}