package com.konkuk.codion.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.konkuk.codion.ui.codiRecord.navigation.codiRecordNavGraph
import com.konkuk.codion.ui.home.navigation.homeNavGraph
import com.konkuk.codion.ui.myCloset.navigation.myClosetNavGraph
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
            startDestination = navigator.startDestination,
        ) {
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