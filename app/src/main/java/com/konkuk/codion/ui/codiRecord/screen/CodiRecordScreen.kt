package com.konkuk.codion.ui.codiRecord.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.konkuk.codion.R
import com.konkuk.codion.ui.codiRecord.component.CodiRecordCalendar
import com.konkuk.codion.ui.codiRecord.dummy.CalendarDay
import com.konkuk.codion.ui.common.dummy.ClothesCardDummyData
import com.konkuk.codion.ui.home.component.ClothesCardList
import java.time.LocalDate

@Composable
fun CodiRecordScreen(modifier: Modifier = Modifier) {
    val today = LocalDate.now()
    //    Scaffold(
    //        topBar = {
    //            // TODO: top app bar 공통 컴포넌트 적용하기
    //        },
    //    ) { innerPadding ->

    Column(
        modifier = modifier
//                .padding(innerPadding)
            .fillMaxSize(),
    ) {
        CodiRecordCalendar(
            CalendarDay.dummyData.toMap()
        )

        ClothesCardList(
            title = stringResource(R.string.wore_clothes, today.month.value, today.dayOfMonth),
            clothesDataList = ClothesCardDummyData.dummyData,
            isEditable = true
        )
    }
    //}
}

@Preview(showBackground = true)
@Composable
private fun CodiRecordScreenPreview() {
    CodiRecordScreen()
}