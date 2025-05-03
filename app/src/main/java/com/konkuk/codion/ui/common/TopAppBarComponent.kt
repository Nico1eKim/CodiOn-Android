package com.konkuk.codion.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray300
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun TopAppBarComponent(
    title: String,
    leftIcon: Painter?,
    onLeftClicked: (() -> Unit)?,
    rightIcon: Painter?,
    onRightClicked: (() -> Unit)?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(63.dp),  // border 높이 뺀 값 (64 - 1 = 63)
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.size(20.dp))

            // 왼쪽 아이콘
            if (leftIcon != null && onLeftClicked != null) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clickable(onClick = onLeftClicked),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Icon(
                        painter = leftIcon,
                        contentDescription = "왼쪽 아이콘",
                        tint = Gray700,
                        modifier = Modifier.fillMaxHeight()
                    )
                }
            } else {
                // null일 때에도 공간은 차지하도록 처리
                Spacer(modifier = Modifier.size(20.dp))
            }

            Box(modifier = Modifier.weight(1f))

            // title
            Text(
                text = title,
                style = CodiOnTypography.pretendard_600_16,
                color = Gray700
            )

            Box(modifier = Modifier.weight(1f))

            // 오른쪽 아이콘
            if (rightIcon != null && onRightClicked != null) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clickable(onClick = onRightClicked),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Icon(
                        painter = rightIcon,
                        contentDescription = "오른쪽 아이콘",
                        tint = Gray700,
                        modifier = Modifier.fillMaxHeight()
                    )
                }
            } else {
                // null일 때에도 공간은 차지하도록 처리
                Spacer(modifier = Modifier.size(20.dp))
            }

            Spacer(modifier = Modifier.size(20.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Gray300)
        )
    }
}

@Preview
@Composable
fun TopAppBarComponentPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center

    ) {
        // (1) title만 존재하는 경우
        TopAppBarComponent(
            title = stringResource(R.string.home),
            leftIcon = null,
            onLeftClicked = null,
            rightIcon = null,
            onRightClicked = null
        )

        Spacer(modifier = Modifier.height(16.dp))

        // (2) 왼쪽 아이콘만 존재하는 경우
        TopAppBarComponent(
            title = stringResource(R.string.find_pwd),
            leftIcon = painterResource(R.drawable.ic_back),
            onLeftClicked = { },
            rightIcon = null,
            onRightClicked = null
        )

        Spacer(modifier = Modifier.height(16.dp))

        // (3) 오른쪽 아이콘만 존재하는 경우
        TopAppBarComponent(
            title = stringResource(R.string.my_closet),
            leftIcon = null,
            onLeftClicked = null,
            rightIcon = painterResource(R.drawable.ic_add),
            onRightClicked = { }
        )
    }
}