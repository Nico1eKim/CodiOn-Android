package com.konkuk.codion.ui.navigator

import kotlinx.serialization.Serializable

sealed interface Routes {
    // Home
    @Serializable
    data object Home : Routes

    // codiRecord
    @Serializable
    data object CodiRecord : Routes
    @Serializable
    data object RegisterCodiComment : Routes

    // myCloset
    @Serializable
    data object MyCloset : Routes
    @Serializable
    data object AddMyClothesDetail : Routes
    @Serializable
    data object AddMyClothesPicture : Routes
}