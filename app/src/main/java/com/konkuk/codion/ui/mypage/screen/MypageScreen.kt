package com.konkuk.codion.ui.mypage.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.common.TopAppBarComponent
import com.konkuk.codion.ui.mypage.component.MypageMenuComponent
import com.konkuk.codion.ui.mypage.component.ProfileBoxComponent
import com.konkuk.codion.ui.mypage.dummy.ProfileDummyData
import com.konkuk.codion.ui.theme.Gray300

@Composable
fun MypageScreen() {
    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = stringResource(R.string.mypage),
                leftIcon = null,
                onLeftClicked = null,
                rightIcon = null,
                onRightClicked = null
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
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
                    isRightIconVisible = true,
                    onClicked = {}
                )
                MypageMenuComponent(
                    label = stringResource(R.string.change_pwd),
                    isRightIconVisible = true,
                    onClicked = {}
                )
                MypageMenuComponent(
                    label = stringResource(R.string.logout),
                    isRightIconVisible = false,
                    onClicked = {}
                )
                MypageMenuComponent(
                    label = stringResource(R.string.withdrawal),
                    isRightIconVisible = false,
                    onClicked = {}
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // TODO: 네비게이션바 추가
        }
    }
}

@Preview
@Composable
fun MypageScreenPreview() {
    MypageScreen()
}