package com.konkuk.codion.ui.myCloset.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.konkuk.codion.ui.myCloset.screen.AddMyClothesPictureScreen
import com.konkuk.codion.ui.myCloset.screen.MyClosetScreen
import com.konkuk.codion.ui.navigation.MainTabRoute
import com.konkuk.codion.ui.navigation.Routes

fun NavController.navigateToMyCloset(navOptions: NavOptions) {
    navigate(MainTabRoute.MyCloset, navOptions)
}

fun NavController.navigateToAddMyClothesPicture() {
    navigate(Routes.AddMyClothesPicture)
}

fun NavGraphBuilder.myClosetNavGraph(
    padding: PaddingValues,
    navigateBack: () -> Unit,
    navigateToAddMyClothesPicture: () -> Unit,

) {
    composable<MainTabRoute.MyCloset> {
        MyClosetScreen(
            padding = padding,
            onAddClick = navigateToAddMyClothesPicture
        )
    }

    composable<Routes.AddMyClothesPicture> {
        AddMyClothesPictureScreen(
            padding = padding,
            onBackClick = navigateBack,
        )
    }
}