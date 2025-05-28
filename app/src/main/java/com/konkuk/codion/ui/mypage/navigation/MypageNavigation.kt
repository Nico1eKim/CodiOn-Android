package com.konkuk.codion.ui.mypage.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.konkuk.codion.ui.common.TopAppBarState
import com.konkuk.codion.ui.mypage.screen.MypageScreen
import com.konkuk.codion.ui.navigation.MainTabRoute

fun NavController.navigateToMypage(navOptions: NavOptions) {
    navigate(MainTabRoute.MyPage, navOptions)
}

fun NavGraphBuilder.mypageNavGraph(
    padding: PaddingValues,
    setTopAppBar: (TopAppBarState?) -> Unit
) {
    composable<MainTabRoute.MyPage> {
        MypageScreen(
            padding = padding,
            setTopAppBar = setTopAppBar
        )
    }
}