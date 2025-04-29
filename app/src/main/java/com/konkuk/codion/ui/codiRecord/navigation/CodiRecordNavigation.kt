package com.konkuk.codion.ui.codiRecord.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.konkuk.codion.ui.codiRecord.screen.CodiRecordScreen
import com.konkuk.codion.ui.navigation.MainTabRoute
import com.konkuk.codion.ui.navigation.Routes

fun NavController.navigateToCodiRecord(navOptions: NavOptions) {
    navigate(MainTabRoute.CodiRecord, navOptions)
}

fun NavController.navigateToAddMyClothesPicture() {
    navigate(Routes.AddMyClothesPicture)
}

fun NavGraphBuilder.codiRecordNavGraph(
    padding: PaddingValues,
    navigateToAddMyClothesPicture: () -> Unit,
) {
    composable<MainTabRoute.CodiRecord> {
        CodiRecordScreen(
            padding = padding,
            onAddClick = navigateToAddMyClothesPicture,
        )
    }
}