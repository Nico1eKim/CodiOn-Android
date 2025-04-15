package com.konkuk.codion.ui.util

import com.konkuk.codion.R
import com.konkuk.codion.ui.codiRecord.EmotionType

fun getEmotionIcon(emotion: EmotionType): Int {
    return when (emotion) {
        EmotionType.HAPPY -> R.drawable.ic_happy
        EmotionType.SAD -> R.drawable.ic_sad
        EmotionType.NEUTRAL -> R.drawable.ic_neutral
    }
}