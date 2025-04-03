package com.konkuk.codion.ui.mypage.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.konkuk.codion.ui.mypage.dummy.ProfileDummyData
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray500
import com.konkuk.codion.ui.theme.Gray700
import com.konkuk.codion.ui.theme.Gray900

@Composable
fun EditProfileScreen(
    profile: ProfileDummyData
) {
    // 상단바
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.statusBars.asPaddingValues()),  // 상태바 아래부터 컴포넌트가 붙도록 처리
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBarComponent(
            title = stringResource(R.string.edit_profile),
            leftIcon = painterResource(R.drawable.ic_back),
            onLeftClicked = { },
            rightIcon = null,
            onRightClicked = null
        )

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier.width(320.dp)
        ) {
            // 별명
            InputFieldComponent(
                label = stringResource(R.string.nickname),
                isRequired = true,
                placeholder = stringResource(R.string.nickname_ph),
                inputText = "홍길동",
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
            Box(
                modifier = Modifier
                    .size(320.dp, 40.dp)
                    .border(1.dp, Gray500, shape = RoundedCornerShape(6.dp))
                    .padding(start = 10.dp, end = 10.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = profile.personal,
                    style = CodiOnTypography.pretendard_400_14,
                    color = Gray700
                )
            }
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

            // 프로필 수정하기 버튼
            BigButtonComponent(
                containerColor = Gray900,
                contentColor = Gray100,
                text = stringResource(R.string.edit_profile) + "하기"
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview
@Composable
fun EditProfileScreenPreview() {
    EditProfileScreen(
        profile = ProfileDummyData.dummyData
    )
}