package com.konkuk.codion.ui.mypage.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.common.TopAppBarComponent
import com.konkuk.codion.ui.mypage.component.MypageMenuComponent
import com.konkuk.codion.ui.mypage.component.ProfileBoxComponent
import com.konkuk.codion.ui.mypage.dummy.ProfileDummyData
import com.konkuk.codion.ui.theme.Gray300

@Composable
fun MypageScreen() {
    // 상단바
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.statusBars.asPaddingValues()),  // 상태바 아래부터 컴포넌트가 붙도록 처리
    ) {
        TopAppBarComponent(
            title = stringResource(R.string.mypage),
            leftIcon = null,
            onLeftClicked = null,
            rightIcon = null,
            onRightClicked = null
        )

        Spacer(modifier = Modifier.height(20.dp))

        // profile box
        Box(
            modifier = Modifier.padding(start = 20.dp)
        ) {
            ProfileBoxComponent(
                profile = ProfileDummyData.dummyData
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        HorizontalDivider(
            modifier = Modifier.height(1.dp),
            color = Gray300
        )

        // menu
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            MypageMenuComponent(
                label = stringResource(R.string.edit_profile),
                showRightIcon = true,
                onClicked = {}
            )
            MypageMenuComponent(
                label = stringResource(R.string.change_pwd),
                showRightIcon = true,
                onClicked = {}
            )
            MypageMenuComponent(
                label = stringResource(R.string.logout),
                showRightIcon = false,
                onClicked = {}
            )
            MypageMenuComponent(
                label = stringResource(R.string.withdrawal),
                showRightIcon = false,
                onClicked = {}
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // TODO: 네비게이션바 추가
    }
}
