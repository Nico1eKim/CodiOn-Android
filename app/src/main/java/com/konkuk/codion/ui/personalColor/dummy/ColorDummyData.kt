package com.konkuk.codion.ui.personalColor.dummy

import androidx.compose.ui.graphics.Color
import com.konkuk.codion.R

data class ColorDummyData(
    val personalColorId: Int,  // 퍼스널컬러
    val mainImageResourceId: Int,  // 사진
    val imageList: List<String> = listOf(),  // 이미지 설명
    val eyeList: List<String> = listOf(),  // 눈빛 설명
    val skin: String = "",  // 피부톤 설명
    val paletteColors: List<Color> = listOf()  // 컬러 팔레트
) {
    companion object {
        val autumnDummyData = ColorDummyData(
            personalColorId = R.string.personal_color_autumn,
            mainImageResourceId = R.drawable.img_color_autumn,
            imageList = listOf(
                "차분함",
                "고상",
                "지적",
                "깊이 있음"
            ),
            eyeList = listOf(
                "부드러움",
                "깊이 있고 탁함"
            ),
            skin = "비치치 않는 갈색톤",
            paletteColors = listOf(
                // line 1
                Color(0xFFFEE69C),
                Color(0xFFFED106),
                Color(0xFFE89619),
                Color(0xFFE36E21),
                Color(0xFFDE3A21),
                Color(0xFFF49D8C),
                Color(0xFFB61F16),
                Color(0xFF863204),
                Color(0xFFE7C190),
                // line 2
                Color(0xFF9F6712),
                Color(0xFF7F5719),
                Color(0xFF9A7E11),
                Color(0xFFCCB776),
                Color(0xFF5A592B),
                Color(0xFF77A131),
                Color(0xFF4D6F1B),
                Color(0xFFA8D49F),
                Color(0xFF053E09),
                // line 3
                Color(0xFF03535E),
                Color(0xFF552030),
                Color(0xFF767561),
                Color(0xFF523A30),
                Color(0xFFDBBD97),
                Color(0xFFD7A00F),
                Color(0xFFB25C11),
                Color(0xFFC0AF01),
                Color(0xFFB3AB7D)
            )
        )
    }
}
