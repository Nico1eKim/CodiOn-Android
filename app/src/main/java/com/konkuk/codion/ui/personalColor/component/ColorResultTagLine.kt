package com.konkuk.codion.ui.personalColor.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun ColorResultTagLine(
    personalColor: String,
    tag: String
) {
    Row {
        Text(
            text = "# $personalColor ",
            style = CodiOnTypography.pretendard_600_14.copy(
                lineHeight = 21.sp
            ),
            color = Gray700,
        )
        Text(
            text = tag,
            style = CodiOnTypography.pretendard_400_14.copy(
                lineHeight = 21.sp
            ),
            color = Gray700,
        )
    }
}

@Preview
@Composable
fun ColorResultTagLinePreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ColorResultTagLine(
            personalColor = "가을 웜",
            tag = "특징"
        )
        ColorResultTagLine(
            personalColor = "가을 웜",
            tag = "컬러 팔레트"
        )
    }
}