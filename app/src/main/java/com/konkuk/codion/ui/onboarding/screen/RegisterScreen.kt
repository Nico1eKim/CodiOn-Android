package com.konkuk.codion.ui.onboarding.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Text
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
import com.konkuk.codion.ui.common.buttons.BigButtonWithIconComponent
import com.konkuk.codion.ui.common.inputFields.InputFieldComponent
import com.konkuk.codion.ui.onboarding.component.TermsBoxComponent
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray700
import com.konkuk.codion.ui.theme.Gray900

@Composable
fun RegisterScreen() {
    // 상단바
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.statusBars.asPaddingValues()),  // 상태바 아래부터 컴포넌트가 붙도록 처리
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBarComponent(
            title = stringResource(R.string.register),
            leftIcon = painterResource(R.drawable.ic_back),
            onLeftClicked = { },
            rightIcon = null,
            onRightClicked = null
        )

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            // 약관 동의
            Text(
                text = stringResource(R.string.terms) + " *",
                style = CodiOnTypography.pretendard_600_14,
                color = Gray700
            )
            Spacer(modifier = Modifier.height(4.dp))

            TermsBoxComponent()

            Spacer(modifier = Modifier.height(20.dp))

            // 별명
            InputFieldComponent(
                label = stringResource(R.string.nickname),
                isRequired = true,
                placeholder = stringResource(R.string.nickname_ph),
                inputText = "",
                onTextChanged = { }
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 퍼스널컬러
            Text(
                text = stringResource(R.string.personal_color) + " *",
                style = CodiOnTypography.pretendard_600_14,
                color = Gray700
            )
            Spacer(modifier = Modifier.height(4.dp))
            BigButtonWithIconComponent(
                text = stringResource(id = R.string.enter_yourself),
                icon = painterResource(id = R.drawable.ic_write)
            )
            Spacer(modifier = Modifier.height(4.dp))
            BigButtonWithIconComponent(
                text = stringResource(id = R.string.camera_personal_color),
                icon = painterResource(id = R.drawable.ic_camera)
            )

            Spacer(modifier = Modifier.weight(1f))

            // 회원가입 완료 버튼
            BigButtonComponent(
                containerColor = Gray900,
                contentColor = Gray100,
                text = stringResource(R.string.register_done)
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}