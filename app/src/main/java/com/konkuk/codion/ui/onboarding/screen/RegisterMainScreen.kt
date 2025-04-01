package com.konkuk.codion.ui.onboarding.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.common.TopAppBarComponent
import com.konkuk.codion.ui.common.buttons.BigButtonWithIconComponent
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray900

@Composable
fun RegisterMainScreen() {
    // 상단바
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.statusBars.asPaddingValues())  // 상태바 아래부터 컴포넌트가 붙도록 처리
    ) {
        TopAppBarComponent(
            title = stringResource(R.string.register),
            leftIcon = painterResource(R.drawable.ic_back),
            onLeftClicked = { },
            rightIcon = null,
            onRightClicked = null
        )
    }

    // 중앙 정렬된 요소들
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.width(320.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.app_name),
                style = CodiOnTypography.pretendard_700_64,
                color = Gray900
            )
            Spacer(modifier = Modifier.height(72.dp))
            BigButtonWithIconComponent(
                text = stringResource(id = R.string.register_email),
                icon = painterResource(id = R.drawable.ic_mail)
            )
            Spacer(modifier = Modifier.height(16.dp))
            // TODO("카카오톡 회원가입 버튼 추가")
        }
    }
}
