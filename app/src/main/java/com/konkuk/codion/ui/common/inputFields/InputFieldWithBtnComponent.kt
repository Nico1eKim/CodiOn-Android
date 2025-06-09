package com.konkuk.codion.ui.common.inputFields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.common.buttons.SmallButtonComponent
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray900
import com.konkuk.codion.ui.theme.Green

@Composable
fun InputFieldWithBtnComponent(
    label: String,
    placeholder: String,
    inputText: String,
    onTextChange: (String) -> Unit,
    btnText: String,
    showTimer: Boolean = false,
    timerSeconds: Int? = null,
    helperText: String? = null,
    onBtnClick: (() -> Unit)? = null
) {
    var timer by remember { mutableStateOf(timerSeconds ?: 0) }

    LaunchedEffect(showTimer) {
        if (showTimer && timerSeconds != null) {
            timer = timerSeconds
            while (timer > 0) {
                kotlinx.coroutines.delay(1000L)
                timer--
            }
        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.fillMaxWidth()
        ) {
            InputFieldComponent(
                label = label,
                isRequired = true,
                placeholder = placeholder,
                inputText = inputText,
                onTextChange = onTextChange,
                showTimer = showTimer,
                timerSeconds = timer,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            SmallButtonComponent(
                modifier = Modifier.width(100.dp),
                containerColor = Gray900,
                contentColor = Gray100,
                contentPadding = PaddingValues(0.dp),
                text = btnText,
                onClick = { onBtnClick?.invoke() }
            )
        }

        // ✅ 헬퍼 텍스트 출력
        if (!helperText.isNullOrEmpty()) {
            Text(
                text = helperText,
                color = Green,
                style = CodiOnTypography.pretendard_500_14,
                modifier = Modifier
                    .padding(top = 4.dp, start = 4.dp)
                    .align(Alignment.Start)
            )
        }
    }
}

@Preview
@Composable
private fun InputFieldWithBtnComponentPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp), verticalArrangement = Arrangement.Center
    ) {
        InputFieldWithBtnComponent(
            label = stringResource(R.string.email),
            placeholder = stringResource(R.string.email_ph),
            inputText = "",
            onTextChange = {},
            btnText = stringResource(R.string.code_btn_send)
        )
        Spacer(modifier = Modifier.height(16.dp))
        InputFieldWithBtnComponent(
            label = stringResource(R.string.code),
            placeholder = stringResource(R.string.code_ph),
            inputText = "",
            onTextChange = {},
            btnText = stringResource(R.string.code_btn_done),
            showTimer = true,
            timerSeconds = 180
        )
        Spacer(modifier = Modifier.height(16.dp))
        InputFieldWithBtnComponent(
            label = stringResource(R.string.code),
            placeholder = stringResource(R.string.code_ph),
            inputText = "12345678",
            onTextChange = {},
            btnText = stringResource(R.string.code_btn_done),
            showTimer = true,
            timerSeconds = 140
        )
    }
}