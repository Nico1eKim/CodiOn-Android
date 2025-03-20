package com.konkuk.codion.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray900

@Composable
fun ChipComponent(chipText: String) {
    Row(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(18.dp))
            .background(color = Gray900)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = chipText,
            style = CodiOnTypography.pretendard_600_12,
            color = Gray100
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ChipComponentPreview() {
    Column {
        ChipComponent(stringResource(id = R.string.chip_date))
        ChipComponent(stringResource(id = R.string.chip_casual))
        ChipComponent(stringResource(id = R.string.chip_travel))
        ChipComponent(stringResource(id = R.string.chip_workout))
        ChipComponent(stringResource(id = R.string.chip_business))
    }
}