package com.konkuk.codion.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import com.konkuk.codion.ui.common.dummy.ClothesCardDummyData
import com.konkuk.codion.ui.home.component.ClothesCardList
import com.konkuk.codion.ui.home.component.WeatherInformation
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray300
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun HomeScreen(
    padding: PaddingValues,
) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = stringResource(R.string.home),
                leftIcon = null,
                onLeftClicked = null,
                rightIcon = null,
                onRightClicked = null
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(scrollState),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.home_nickname, "닉네임"),
                    style = CodiOnTypography.pretendard_400_16,
                    color = Gray700,
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_map_pin),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                )

                Row(
                    modifier = Modifier
                        .padding(start = 4.dp)
                ) {
                    // TODO: 지역 바텀시트 만들기
                    Text(
                        text = "서초구",
                        style = CodiOnTypography.pretendard_700_16,
                        color = Gray700,
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_down),
                        contentDescription = null,
                        modifier = Modifier
                            .size(16.dp)
                    )
                }

                Text(
                    text = stringResource(R.string.sensory_temp_is),
                    style = CodiOnTypography.pretendard_400_16,
                    color = Gray700,
                )

                Text(
                    text = stringResource(R.string.temperature_unit, 20),
                    style = CodiOnTypography.pretendard_700_16,
                    color = Gray700,
                    modifier = Modifier.padding(start = 4.dp)
                )

                Text(
                    text = stringResource(R.string.end_word),
                    style = CodiOnTypography.pretendard_400_16,
                    color = Gray700,
                )
            }

            WeatherInformation(Modifier.padding(top = 8.dp, start = 20.dp, end = 20.dp), 9, 4, 0)

            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp),
                color = Gray300,
            )
            Spacer(modifier = Modifier.height(24.dp))

            ClothesCardList(
                title = stringResource(R.string.today_clothes),
                clothesDataList = ClothesCardDummyData.dummyData
            )

            Spacer(modifier = Modifier.height(32.dp))

            ClothesCardList(
                title = stringResource(R.string.unusual_clothes),
                clothesDataList = ClothesCardDummyData.dummyData
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(padding = PaddingValues(0.dp))
}