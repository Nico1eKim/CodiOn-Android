package com.konkuk.codion.ui.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.konkuk.codion.ui.navigation.MainTabRoute
import com.konkuk.codion.ui.navigation.Routes
import com.konkuk.codion.ui.onboarding.screen.LoginScreen
import com.konkuk.codion.ui.onboarding.screen.SplashScreen
import com.konkuk.codion.ui.onboarding.viewmodel.LoginViewModel

fun NavController.navigateToLogin() {
    navigate(Routes.Login)
}

fun NavController.navigateOnboardingToHome() {
    navigate(MainTabRoute.Home) {
        popUpTo(Routes.Splash) {
            inclusive = true
        }
    }
}

fun NavGraphBuilder.onboardingNavGraph(
    navigateToLogin: () -> Unit,
    navigateOnboardingToHome: () -> Unit,
) {
    composable<Routes.Splash> {
        SplashScreen(
            navigateToLogin = navigateToLogin
        )
    }
    composable<Routes.Login> {
        LoginScreen(
            navigateToHome = navigateOnboardingToHome
        )
    }
}