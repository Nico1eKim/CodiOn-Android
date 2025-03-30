package com.konkuk.codion.ui.common.inputFields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.common.buttons.SmallButtonComponent
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray900

@Composable
fun InputFieldWithBtnComponent(
    label: String,
    placeholder: String,
    inputText: String,
    btnText: String,
    showTimer: Boolean = false,
    timerSeconds: Int? = null,
) {
    Row(
        verticalAlignment = Alignment.Bottom
    ) {
        InputFieldComponent(
            label = label,
            isRequired = true,
            placeholder = placeholder,
            inputText = inputText,
            width = 212.dp,
            showTimer = showTimer,
            timerSeconds = timerSeconds
        )
        Spacer(modifier = Modifier.width(8.dp))
        SmallButtonComponent(
            modifier = Modifier.width(100.dp),
            containerColor = Gray900,
            contentColor = Gray100,
            contentPadding = PaddingValues(0.dp),
            text = btnText
        )
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
            btnText = stringResource(R.string.code_btn_send)
        )
        Spacer(modifier = Modifier.height(16.dp))
        InputFieldWithBtnComponent(
            label = stringResource(R.string.code),
            placeholder = stringResource(R.string.code_ph),
            inputText = "",
            btnText = stringResource(R.string.code_btn_done),
            showTimer = true,
            timerSeconds = 180
        )
        Spacer(modifier = Modifier.height(16.dp))
        InputFieldWithBtnComponent(
            label = stringResource(R.string.code),
            placeholder = stringResource(R.string.code_ph),
            inputText = "12345678",
            btnText = stringResource(R.string.code_btn_done),
            showTimer = true,
            timerSeconds = 140
        )
    }
}