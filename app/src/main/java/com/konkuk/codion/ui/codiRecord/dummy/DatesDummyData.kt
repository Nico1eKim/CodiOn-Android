package com.konkuk.codion.ui.codiRecord.dummy

import com.konkuk.codion.ui.codiRecord.EmotionType
import java.time.LocalDate

data class CalendarDay(
    val date: LocalDate,
    val emotion: EmotionType? = null,
    val isCurrentMonth: Boolean = true
) {
    companion object {
        val dummyData = listOf(
            LocalDate.of(2025, 3, 14) to EmotionType.HAPPY,
            LocalDate.of(2025, 3, 15) to EmotionType.HAPPY,
            LocalDate.of(2025, 3, 16) to EmotionType.HAPPY,
            LocalDate.of(2025, 3, 17) to EmotionType.SAD,
            LocalDate.of(2025, 3, 18) to EmotionType.HAPPY,
            LocalDate.of(2025, 3, 19) to EmotionType.NEUTRAL,
            LocalDate.of(2025, 3, 24) to EmotionType.SAD,
            LocalDate.of(2025, 3, 25) to EmotionType.NEUTRAL,
            LocalDate.now() to EmotionType.HAPPY // 오늘
        )
    }
}