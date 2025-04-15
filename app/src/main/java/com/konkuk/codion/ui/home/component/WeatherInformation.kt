package com.konkuk.codion.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import com.konkuk.codion.ui.theme.Gray500
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun WeatherInformation(modifier: Modifier = Modifier, temp: Int, wind: Int, rain: Int) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.today_weather),
            style = CodiOnTypography.pretendard_400_12,
            color = Gray500,
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(top = 8.dp).height(68.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(80.dp),
        ) {
            item {
                WeatherInformationRow(
                    painterId = R.drawable.ic_temperature,
                    informationId = R.string.temperature,
                    value = temp
                )
            }

            item {
                WeatherInformationRow(
                    painterId = R.drawable.ic_wind,
                    informationId = R.string.wind_speend,
                    value = wind
                )
            }

            item {
                WeatherInformationRow(
                    painterId = R.drawable.ic_rain,
                    informationId = R.string.rainfall,
                    value = rain
                )
            }

        }

    }
}

@Composable
fun WeatherInformationRow(painterId: Int, informationId: Int, value: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = painterId),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
        )

        Text(
            text = stringResource(informationId, value),
            style = CodiOnTypography.pretendard_600_14,
            color = Gray700,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WeatherInformationPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        WeatherInformation(Modifier,9, 4, 0)
    }

}