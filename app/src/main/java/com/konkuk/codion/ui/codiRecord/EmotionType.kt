package com.konkuk.codion.ui.codiRecord

import androidx.annotation.DrawableRes
import com.konkuk.codion.R

enum class EmotionType(
    val label: String,
    @DrawableRes val iconResId: Int
) {
    HAPPY("좋음", R.drawable.ic_happy),
    NEUTRAL("보통", R.drawable.ic_neutral),
    SAD("나쁨", R.drawable.ic_sad)
}