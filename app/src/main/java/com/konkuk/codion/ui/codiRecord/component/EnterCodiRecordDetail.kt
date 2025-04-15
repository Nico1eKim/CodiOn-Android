package com.konkuk.codion.ui.codiRecord.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konkuk.codion.R
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray200
import com.konkuk.codion.ui.theme.Gray500
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun EnterCodiRecordDetail(
    text: String,
    onTextChange: (String) -> Unit,
) {
    Column(
        Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.detail),
            style = CodiOnTypography.pretendard_700_16,
            color = Gray700,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp, top = 24.dp)
        )

        BasicTextField(
            value = text,
            onValueChange = { onTextChange(it) },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Gray200, shape = RoundedCornerShape(12.dp))
                .padding(16.dp),
            textStyle = CodiOnTypography.pretendard_400_16.copy(
                lineHeightStyle = LineHeightStyle(
                    alignment = LineHeightStyle.Alignment.Center,
                    trim = LineHeightStyle.Trim.None
                ),
                lineHeight = 24.sp
            ),
            singleLine = false,
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        // placeholder 노출 여부
                        if (text.isEmpty()) {
                            Text(
                                text = stringResource(R.string.detail_placeholder),
                                style = CodiOnTypography.pretendard_400_14,
                                color = Gray500
                            )
                        }
                        innerTextField()
                    }
                }
            }
        )
    }
}