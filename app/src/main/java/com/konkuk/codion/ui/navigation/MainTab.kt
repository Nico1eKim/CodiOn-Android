package com.konkuk.codion.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.konkuk.codion.R

enum class MainTab(
    @DrawableRes val iconResId: Int,
    @StringRes val contentDescriptionId: Int,
    val route: MainTabRoute,
) {
    HOME(
        iconResId = R.drawable.ic_home,
        contentDescriptionId = R.string.home,
        route = MainTabRoute.Home,
    ),
    CODI_RECORD(
        iconResId = R.drawable.ic_codi_record,
        contentDescriptionId = R.string.codi_record,
        route = MainTabRoute.CodiRecord,
    ),
    MY_CLOSET(
        iconResId = R.drawable.ic_closet,
        contentDescriptionId = R.string.my_closet,
        route = MainTabRoute.MyCloset,
    ),
    MY_PAGE(
        iconResId = R.drawable.ic_mypage,
        contentDescriptionId = R.string.mypage,
        route = MainTabRoute.MyPage,
    );

    companion object {
        @Composable
        fun contains(predicate: @Composable (Routes) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}