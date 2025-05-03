package com.konkuk.codion.ui.common.filter

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray500

@Composable
fun FilterBottomSheetButton(
    placeholder: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .border(1.dp, Gray500, RoundedCornerShape(2.dp))
            .clickable { onClick() }
            .padding(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = placeholder,
                style = CodiOnTypography.pretendard_500_12,
                color = Gray500
            )

            Spacer(modifier = Modifier.width(4.dp))

            Icon(
                painter = painterResource(id = R.drawable.ic_filter_dropdown),
                tint = Color.Unspecified,
                modifier = Modifier.size(16.dp),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FilterBottomSheetButtonPreview() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        FilterBottomSheetButton("퍼스널컬러") {

        }
    }
}