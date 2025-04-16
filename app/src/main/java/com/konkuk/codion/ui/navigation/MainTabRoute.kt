package com.konkuk.codion.ui.navigation

import kotlinx.serialization.Serializable

sealed interface MainTabRoute : Routes {
    @Serializable
    data object Home : MainTabRoute
    @Serializable
    data object CodiRecord : MainTabRoute
    @Serializable
    data object MyCloset : MainTabRoute
    @Serializable
    data object MyPage : MainTabRoute
}