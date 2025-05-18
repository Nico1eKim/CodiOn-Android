package com.konkuk.codion.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    title: String,
    leftIcon: Painter? = null,
    onLeftClicked: (() -> Unit)? = null,
    rightIcon: Painter? = null,
    onRightClicked: (() -> Unit)? = null
) {
    Column {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = title,
                    style = CodiOnTypography.pretendard_600_16,
                    color = Gray700
                )
            },
            navigationIcon = {
                if (leftIcon != null && onLeftClicked != null) {
                    IconButton(
                        onClick = onLeftClicked
                    ) {
                        Icon(
                            painter = leftIcon,
                            contentDescription = "왼쪽 아이콘",
                            tint = Gray700
                        )
                    }

                }
            },
            actions = {
                if (rightIcon != null && onRightClicked != null) {
                    IconButton(
                        onClick = onRightClicked
                    ) {
                        Icon(
                            painter = rightIcon,
                            contentDescription = "오른쪽 아이콘",
                            tint = Gray700
                        )
                    }
                }
            },
        )
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
            title = stringResource(R.string.home)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // (2) 왼쪽 아이콘만 존재하는 경우
        TopAppBarComponent(
            title = stringResource(R.string.find_pwd),
            leftIcon = painterResource(R.drawable.ic_back),
            onLeftClicked = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // (3) 오른쪽 아이콘만 존재하는 경우
        TopAppBarComponent(
            title = stringResource(R.string.my_closet),
            rightIcon = painterResource(R.drawable.ic_add),
            onRightClicked = { }
        )
    }
}