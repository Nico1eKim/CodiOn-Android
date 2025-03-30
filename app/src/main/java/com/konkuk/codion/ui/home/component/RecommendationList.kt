package com.konkuk.codion.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.konkuk.codion.ui.common.ClothesCardComponent
import com.konkuk.codion.ui.common.dummy.ClothesCardDummyData
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun RecommendationList(
    title: Int,
    clothesDataList: List<ClothesCardDummyData>
) {
    val state = rememberLazyListState()

    Column {
        Text(
            text = stringResource(title),
            style = CodiOnTypography.pretendard_700_16,
            color = Gray700,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        LazyRow(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth(),
            state = state,
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(clothesDataList.size) { index ->
                ClothesCardComponent(clothesDataList[index])
            }
        }
    }

}