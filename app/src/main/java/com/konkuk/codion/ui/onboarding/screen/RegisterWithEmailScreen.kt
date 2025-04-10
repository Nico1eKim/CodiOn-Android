package com.konkuk.codion.ui.onboarding.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.common.TopAppBarComponent
import com.konkuk.codion.ui.common.buttons.BigButtonComponent
import com.konkuk.codion.ui.common.inputFields.InputFieldComponent
import com.konkuk.codion.ui.common.inputFields.InputFieldWithBtnComponent
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray900

@Composable
fun RegisterWithEmailScreen() {
    // 상단바
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.statusBars.asPaddingValues()),  // 상태바 아래부터 컴포넌트가 붙도록 처리
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBarComponent(
            title = stringResource(R.string.register_email),
            leftIcon = painterResource(R.drawable.ic_back),
            onLeftClicked = { },
            rightIcon = null,
            onRightClicked = null
        )

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier.padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputFieldWithBtnComponent(
                label = stringResource(R.string.email),
                placeholder = stringResource(R.string.email_ph),
                inputText = "",
                onTextChanged = {},
                btnText = stringResource(R.string.code_btn_send)
            )
            Spacer(modifier = Modifier.height(20.dp))
            InputFieldWithBtnComponent(
                label = stringResource(R.string.code),
                placeholder = stringResource(R.string.code_ph),
                inputText = "",
                onTextChanged = {},
                btnText = stringResource(R.string.code_btn_done),
                showTimer = true,
                timerSeconds = 180
            )
            Spacer(modifier = Modifier.height(20.dp))
            InputFieldComponent(
                label = stringResource(R.string.pwd),
                isRequired = true,
                placeholder = stringResource(R.string.pwd_ph_hint),
                inputText = "",
                onTextChanged = { },
                isPwdField = true,
                isPwdVisible = true,
                onPwdVisibleToggle = { }
            )
            Spacer(modifier = Modifier.height(20.dp))
            InputFieldComponent(
                label = stringResource(R.string.pwd_ph_check),
                isRequired = true,
                placeholder = stringResource(R.string.pwd_ph_hint),
                inputText = "",
                onTextChanged = { },
                isPwdField = true,
                isPwdVisible = true,
                onPwdVisibleToggle = { }
            )
            Spacer(modifier = Modifier.weight(1f))
            BigButtonComponent(
                containerColor = Gray900,
                contentColor = Gray100,
                text = stringResource(R.string.next)
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview
@Composable
fun RegisterWithEmailScreenPreview() {
    RegisterWithEmailScreen()
}