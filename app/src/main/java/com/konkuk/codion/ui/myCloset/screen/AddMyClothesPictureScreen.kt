package com.konkuk.codion.ui.myCloset.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.konkuk.codion.R
import com.konkuk.codion.ui.common.TopAppBarComponent
import com.konkuk.codion.ui.common.buttons.BigButtonComponent
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray600
import com.konkuk.codion.ui.theme.Gray900

@Composable
fun AddMyClothesPictureScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = stringResource(R.string.add_clothes),
                leftIcon = painterResource(R.drawable.ic_back),
                onLeftClicked = {
//                    TODO: 뒤로가기 구현
                },
                rightIcon = null,
                onRightClicked = null
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Gray600)
        ) {
//            TODO: 사진찍기 구현
            Text(
                text = stringResource(R.string.picture_guide),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp),
                color = Gray100,
                style = CodiOnTypography.pretendard_400_14.copy(
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Center,
                        trim = LineHeightStyle.Trim.None
                    ),
                    lineHeight = 24.sp
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Column(
                modifier = Modifier.padding(bottom = 32.dp, start = 20.dp, end = 20.dp)
            ) {
                BigButtonComponent(
                    containerColor = Gray900,
                    contentColor = Gray100,
                    text = stringResource(R.string.take_picture)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AddMyClothesPictureScreenPreview() {
    val navController = rememberNavController()
    AddMyClothesPictureScreen(navController = navController)
}