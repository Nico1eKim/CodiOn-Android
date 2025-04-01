package com.konkuk.codion.ui.codiRecord.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konkuk.codion.R
import com.konkuk.codion.ui.codiRecord.EmotionType
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray500
import com.konkuk.codion.ui.theme.Gray700
import com.konkuk.codion.ui.theme.Gray800

@Composable
fun TodayCodiEmotion(modifier: Modifier = Modifier) {
    var selectedEmotion by remember { mutableStateOf(EmotionType.NEUTRAL) }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.today_codi_evaluation),
            style = CodiOnTypography.pretendard_700_16,
            color = Gray700,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            EmotionType.entries.forEachIndexed { index, emotion ->
                EmotionBox(
                    iconResId = emotion.iconResId,
                    label = emotion.label,
                    isSelected = selectedEmotion == emotion,
                    onClick = { selectedEmotion = emotion }
                )

                if (index != EmotionType.entries.lastIndex) {
                    Spacer(modifier = Modifier.width(36.dp))
                }
            }
        }
    }
}

@Composable
fun EmotionBox(
    iconResId: Int,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            tint = if (isSelected) Gray800 else Gray500,
            modifier = Modifier.padding(bottom = 4.dp).size(48.dp)
        )

        Text(
            text = label,
            style = CodiOnTypography.pretendard_500_16.copy(
                lineHeightStyle = LineHeightStyle(
                    alignment = LineHeightStyle.Alignment.Center,
                    trim = LineHeightStyle.Trim.None
                ),
                lineHeight = 24.sp
            ),
            color = if (isSelected) Gray800 else Gray500,
        )
    }
}