package com.konkuk.codion.ui.mypage.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konkuk.codion.R
import com.konkuk.codion.ui.mypage.dummy.ProfileDummyData
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun ProfileBoxComponent(
    profile: ProfileDummyData
) {
    Column {
        // 박스
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.img_profile),
                contentDescription = "프로필 이미지",
                modifier = Modifier
                    .size(60.dp)
                    .padding(6.dp)
            )
            Spacer(modifier = Modifier.width(14.dp))
            Text(
                text = profile.nickname + "\n" + profile.email,
                style = CodiOnTypography.pretendard_400_16.copy(
                    lineHeight = 24.sp,
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Center,
                        trim = LineHeightStyle.Trim.None
                    ),
                ),
                color = Gray700
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // text
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.month) + " ",
                style = CodiOnTypography.pretendard_400_14,
                color = Gray700
            )
            Text(
                text = stringResource(R.string.app_name),
                style = CodiOnTypography.pretendard_600_14,
                color = Gray700
            )
            Text(
                text = stringResource(R.string.with) + " ",
                style = CodiOnTypography.pretendard_400_14,
                color = Gray700
            )
            Text(
                text = stringResource(R.string.done_codi, profile.monthCodi),
                style = CodiOnTypography.pretendard_600_14.copy(
                    textDecoration = TextDecoration.Underline
                ),
                color = Gray700
            )
            Text(
                text = stringResource(R.string.complete),
                style = CodiOnTypography.pretendard_400_14,
                color = Gray700
            )
        }
    }
}

@Preview
@Composable
fun ProfileBoxComponentPreview() {
    ProfileBoxComponent(
        profile = ProfileDummyData.dummyData
    )
}