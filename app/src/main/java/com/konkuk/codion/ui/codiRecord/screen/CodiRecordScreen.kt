package com.konkuk.codion.ui.codiRecord.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.codiRecord.component.CodiRecordCalendar
import com.konkuk.codion.ui.codiRecord.component.MyComment
import com.konkuk.codion.ui.codiRecord.component.MyCommentEmptyState
import com.konkuk.codion.ui.codiRecord.dummy.CodiRecordDummyData
import com.konkuk.codion.ui.common.dummy.ClothesCardDummyData
import com.konkuk.codion.ui.home.component.ClothesCardList
import java.time.LocalDate

@Composable
fun CodiRecordScreen(modifier: Modifier = Modifier) {
    val codiRecordMap = CodiRecordDummyData.dummyData.associateBy { it.date }

    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    val selectedReview = codiRecordMap[selectedDate]

    val today = LocalDate.now()
    //    Scaffold(
    //        topBar = {
    //            // TODO: top app bar 공통 컴포넌트 적용하기
    //        },
    //    ) { innerPadding ->

    LazyColumn(
        modifier = modifier
//                .padding(innerPadding)
            .fillMaxSize(),
    ) {
        item {
            CodiRecordCalendar(
                recordData = codiRecordMap.mapValues { it.value.emotion },
                onDateSelected = { selectedDate = it }
            )
        }

        item {
            ClothesCardList(
                title = stringResource(
                    R.string.wore_clothes,
                    selectedDate.month.value,
                    selectedDate.dayOfMonth
                ),
                clothesDataList = ClothesCardDummyData.dummyData,
                isEditable = true
            )
        }

        item {
            Spacer(Modifier.height(24.dp))
        }

        item {
            selectedReview?.let {
                MyComment(record = it)
            } ?: MyCommentEmptyState()
        }

    }
    //}
}

@Preview(showBackground = true)
@Composable
private fun CodiRecordScreenPreview() {
    CodiRecordScreen()
}