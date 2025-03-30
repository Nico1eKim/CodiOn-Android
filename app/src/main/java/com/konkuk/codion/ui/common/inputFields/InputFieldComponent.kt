package com.konkuk.codion.ui.common.inputFields

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray500
import com.konkuk.codion.ui.theme.Gray700
import com.konkuk.codion.ui.theme.Red
import java.util.Locale

@Composable
fun InputFieldComponent(
    label: String,
    isRequired: Boolean,
    placeholder: String,
    inputText: String,
    width: Dp = 320.dp,
    showTimer: Boolean = false,
    timerSeconds: Int? = null
) {
    // 필수 입력 여부에 따른 '*' 텍스트 추가 or 미추가 처리
    val labelText = if (isRequired) "$label *" else label

    // 타이머 시간 '분:초' 형식 텍스트로 변환
    val formattedTime = timerSeconds?.let { seconds ->
        String.format(Locale.KOREA, "%02d:%02d", seconds / 60, seconds % 60)
    }

    Column {
        Text(
            text = labelText,
            style = CodiOnTypography.pretendard_600_14,
            color = Gray700
        )
        Spacer(modifier = Modifier.height(4.dp))
        BasicTextField(
            value = inputText,
            onValueChange = { },
            modifier = Modifier
                .size(width, 40.dp)
                .border(1.dp, Gray500, shape = RoundedCornerShape(6.dp))
                .padding(start = 10.dp, end = 10.dp),
            textStyle = CodiOnTypography.pretendard_400_14.copy(color = Gray700),
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        // placeholder 노출 여부
                        if (inputText.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = CodiOnTypography.pretendard_400_14,
                                color = Gray500
                            )
                        }
                        innerTextField()
                    }
                    // timer 노출 여부
                    if (showTimer && formattedTime != null) {
                        Text(
                            text = formattedTime,
                            style = CodiOnTypography.pretendard_400_14,
                            color = Red
                        )
                    }
                }
            }
        )
    }
}

@Preview
@Composable
private fun InputFieldComponentPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp), verticalArrangement = Arrangement.Center
    ) {
        InputFieldComponent(
            stringResource(R.string.pwd),
            false,
            stringResource(R.string.pwd_ph),
            ""
        )
        Spacer(modifier = Modifier.height(16.dp))
        InputFieldComponent(
            stringResource(R.string.pwd),
            true,
            stringResource(R.string.pwd_ph_hint),
            ""
        )
        Spacer(modifier = Modifier.height(16.dp))
        InputFieldComponent(
            stringResource(R.string.pwd),
            true,
            stringResource(R.string.pwd_ph_hint),
            "12345678"
        )
        Spacer(modifier = Modifier.height(16.dp))

        // timer가 존재하는 경우
        InputFieldComponent(
            stringResource(R.string.code),
            true,
            stringResource(R.string.code_ph),
            "",
            width = 212.dp,
            showTimer = true,
            timerSeconds = 180
        )
        Spacer(modifier = Modifier.height(16.dp))
        InputFieldComponent(
            stringResource(R.string.code),
            true,
            stringResource(R.string.code_ph),
            "12345678",
            width = 212.dp,
            showTimer = true,
            timerSeconds = 180
        )
    }
}