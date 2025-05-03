package com.konkuk.codion.ui.common.modifier

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier

// innerPadding 무시를 위한 함수
fun Modifier.ignoreTopPadding(innerPadding: PaddingValues): Modifier {
    return this.padding(top = innerPadding.calculateTopPadding() * 0)
}