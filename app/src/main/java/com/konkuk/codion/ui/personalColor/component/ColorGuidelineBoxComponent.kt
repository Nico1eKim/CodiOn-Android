package com.konkuk.codion.ui.personalColor.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konkuk.codion.R
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun ColorGuidelineBox() {
    val guidelines = listOf(
        R.string.guideline_1,
        R.string.guideline_2,
        R.string.guideline_3,
        R.string.guideline_4
    )

    val spacing = with(LocalDensity.current) { 18.sp.toDp() }   // 18sp를 dp로 변환한 값

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Gray700, shape = RoundedCornerShape(6.dp))
            .padding(10.dp, 42.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(spacing)
        ) {
            // title
            Text(
                text = stringResource(R.string.guideline_title),
                style = CodiOnTypography.pretendard_600_12.copy(
                    lineHeight = 18.sp
                ),
                color = Gray700
            )
            // content
            guidelines.forEachIndexed { index, text ->
                Row {
                    Text(
                        text = "${index + 1}.",
                        style = CodiOnTypography.pretendard_400_12.copy(
                            lineHeight = 18.sp
                        ),
                        color = Gray700,
                        modifier = Modifier.width(14.dp)
                    )
                    Text(
                        text = stringResource(text),
                        style = CodiOnTypography.pretendard_400_12.copy(
                            lineHeight = 18.sp
                        ),
                        color = Gray700
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ColorGuidelineBoxPreview() {
    ColorGuidelineBox()
}