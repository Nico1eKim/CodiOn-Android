package com.konkuk.codion.ui.common

data class TopAppBarState(
    val titleId: Int? = null,
    val leftIconId: Int? = null,
    val onLeftClicked: (() -> Unit)? = null,
    val rightIconId: Int? = null,
    val onRightClicked: (() -> Unit)? = null
)