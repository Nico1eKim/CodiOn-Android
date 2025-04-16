package com.konkuk.codion.ui.codiRecord.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.konkuk.codion.R
import com.konkuk.codion.ui.codiRecord.component.CodiRecordCalendar
import com.konkuk.codion.ui.codiRecord.component.CodiRecordEmpty
import com.konkuk.codion.ui.codiRecord.component.MyComment
import com.konkuk.codion.ui.codiRecord.dummy.CodiRecordDummyData
import com.konkuk.codion.ui.common.TopAppBarComponent
import com.konkuk.codion.ui.common.dummy.ClothesCardDummyData
import com.konkuk.codion.ui.home.component.ClothesCardList
import java.time.LocalDate

@Composable
fun CodiRecordScreen(
    padding: PaddingValues,
) {
    val codiRecordMap = CodiRecordDummyData.dummyData.associateBy { it.date }

    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    val selectedReview = codiRecordMap[selectedDate]

    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = stringResource(R.string.codi_record),
                leftIcon = null,
                onLeftClicked = null,
                rightIcon = null,
                onRightClicked = null
            )
        },
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(padding),
        ) {
            item {
                CodiRecordCalendar(
                    recordData = codiRecordMap.mapValues { it.value.emotion },
                    onDateSelected = { selectedDate = it }
                )
            }

            item {
                selectedReview?.let {
                    Column {
                        ClothesCardList(
                            title = stringResource(
                                R.string.wore_clothes,
                                selectedDate.month.value,
                                selectedDate.dayOfMonth
                            ),
                            clothesDataList = ClothesCardDummyData.dummyData,
                            isEditable = true
                        )

                        Spacer(Modifier.height(24.dp))

                        MyComment(record = it)
                    }
                } ?: CodiRecordEmpty()
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CodiRecordScreenPreview() {
    val navController = rememberNavController()
    CodiRecordScreen(padding = PaddingValues(0.dp))
}