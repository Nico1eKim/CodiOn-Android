package com.konkuk.codion.ui.personalColor.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray500
import com.konkuk.codion.ui.theme.Gray900

@Composable
fun CustomProgressBar(
    progress: Float
) {
    val progressPercentage = (progress * 100).toInt()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(20.dp)
            .clip(RoundedCornerShape(100))
            .background(Gray500)
    ) {
        // 진행 바
        Box(
            modifier = Modifier
                .fillMaxWidth(progress)
                .height(20.dp)
                .clip(RoundedCornerShape(100))
                .background(Gray900),
        )

        // percent text
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$progressPercentage%",
                style = CodiOnTypography.pretendard_400_12,
                color = Gray100
            )
        }
    }
}

@Preview
@Composable
fun CustomProgressBarPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CustomProgressBar(progress = 0.1f)
        CustomProgressBar(progress = 0.3f)
        CustomProgressBar(progress = 0.6f)
    }
}