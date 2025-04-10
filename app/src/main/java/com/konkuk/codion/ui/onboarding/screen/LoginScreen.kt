package com.konkuk.codion.ui.onboarding.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.common.buttons.BigButtonComponent
import com.konkuk.codion.ui.common.inputFields.InputFieldComponent
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray500
import com.konkuk.codion.ui.theme.Gray900

@Composable
fun LoginScreen() {
    var emailInputTest by remember { mutableStateOf("") }
    var pwdInputTest by remember { mutableStateOf("") }
    var isPwdVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // 중앙에 보이는 UI
        Column(
            modifier = Modifier.padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.app_name),
                style = CodiOnTypography.pretendard_700_64,
                color = Gray900
            )
            Spacer(modifier = Modifier.height(16.dp))
            InputFieldComponent(
                label = stringResource(R.string.email),
                isRequired = false,
                placeholder = stringResource(R.string.email_ph),
                inputText = emailInputTest,
                onTextChanged = { emailInputTest = it }
            )
            Spacer(modifier = Modifier.height(32.dp))
            InputFieldComponent(
                label = stringResource(R.string.pwd),
                isRequired = false,
                placeholder = stringResource(R.string.pwd_ph),
                inputText = pwdInputTest,
                onTextChanged = { pwdInputTest = it },
                isPwdField = true,
                isPwdVisible = isPwdVisible,
                onPwdVisibleToggle = { isPwdVisible = !isPwdVisible }
            )
            Spacer(modifier = Modifier.height(32.dp))
            BigButtonComponent(
                containerColor = Gray900,
                contentColor = Gray100,
                text = stringResource(R.string.login)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp),
                    color = Gray500
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(R.string.or),
                    style = CodiOnTypography.pretendard_400_12,
                    color = Gray500
                )
                Spacer(modifier = Modifier.width(4.dp))
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp),
                    color = Gray500
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            // TODO("카카오톡 로그인 버튼 추가")
        }

        // 하단 텍스트 (회원가입 | 비밀번호 찾기)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp)
                .align(Alignment.BottomCenter),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.register),
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clickable { /* TODO("클릭 처리") */ },
                    style = CodiOnTypography.pretendard_500_14.copy(
                        textDecoration = TextDecoration.Underline
                    ),
                    color = Gray500
                )

                Text(
                    text = "|",
                    style = CodiOnTypography.pretendard_500_14,
                    color = Gray500
                )

                Text(
                    text = stringResource(R.string.find_pwd),
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable { /* TODO("클릭 처리") */ },
                    style = CodiOnTypography.pretendard_500_14.copy(
                        textDecoration = TextDecoration.Underline
                    ),
                    color = Gray500
                )
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}