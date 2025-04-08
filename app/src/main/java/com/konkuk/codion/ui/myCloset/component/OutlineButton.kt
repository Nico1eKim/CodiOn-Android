package com.konkuk.codion.ui.myCloset.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun OutlineButton(
    modifier: Modifier = Modifier,
    label: String,
    isClicked: Boolean? = false,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(
                if (isClicked == true) Gray700 else Gray100,
                shape = RoundedCornerShape(6.dp)
            )
            .border(1.dp, Gray700, shape = RoundedCornerShape(6.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = CodiOnTypography.pretendard_400_14,
            color = if (isClicked == true) Gray100 else Gray700
        )
    }
}