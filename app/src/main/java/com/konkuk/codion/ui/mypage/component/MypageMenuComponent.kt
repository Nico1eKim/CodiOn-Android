package com.konkuk.codion.ui.mypage.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray300
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun MypageMenuComponent(
    label: String,
    showRightIcon: Boolean,
    onClicked: (() -> Unit)
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(39.dp)  // 40 - 1 = 39
            .padding(horizontal = 20.dp)
            .clickable { onClicked() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = CodiOnTypography.pretendard_400_14,
            color = Gray700
        )
        Spacer(modifier = Modifier.weight(1f))
        // 오른쪽 아이콘
        if (showRightIcon) {
            Box(
                modifier = Modifier.height(20.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_mypage_arrow_right),
                    contentDescription = "오른쪽 아이콘",
                    tint = Gray700,
                    modifier = Modifier.fillMaxHeight()
                )
            }
        }
    }
    HorizontalDivider(
        modifier = Modifier.height(1.dp),
        color = Gray300
    )
}

@Preview
@Composable
fun MypageMenuComponentPreview() {
    Column {
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
}