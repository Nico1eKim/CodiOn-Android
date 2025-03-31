package com.konkuk.codion.ui.codiRecord.dummy

import com.konkuk.codion.ui.codiRecord.EmotionType
import java.time.LocalDate

data class CodiRecordDummyData(
    val date: LocalDate,
    val emotion: EmotionType,
    val content: String
) {
    companion object {
        val dummyData = listOf(
            CodiRecordDummyData(
                date = LocalDate.now(),
                emotion = EmotionType.HAPPY,
                content = "니트를 입고 나갔더니 친구들이 다 이쁘다고 칭찬해줬다. 하지만 살짝 추운 감이 있었다. 니트와 매치한 바지도 색상이 잘 어울려서 좋았다. 상황에도 적합한 옷이었다."
            ),
            CodiRecordDummyData(
                date = LocalDate.of(2025, 3, 17),
                emotion = EmotionType.SAD,
                content = "아침에 급하게 나가느라 코디를 신경 못 썼다. 바람막이 하나 걸쳤는데 전체적으로 어울리진 않았다."
            ),
            CodiRecordDummyData(
                date = LocalDate.of(2025, 3, 25),
                emotion = EmotionType.NEUTRAL,
                content = "평범한 코디였지만 무난하게 하루를 보냈다. 눈에 띄진 않았지만 불편함도 없었다."
            )
        )
    }
}
