package com.konkuk.codion.ui.codiRecord.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.codiRecord.EmotionType
import com.konkuk.codion.ui.codiRecord.dummy.CalendarDay
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray300
import com.konkuk.codion.ui.theme.Gray700
import com.konkuk.codion.ui.util.getEmotionIcon
import java.time.LocalDate
import java.time.YearMonth

@Composable
fun CodiRecordCalendar(
    recordData: Map<LocalDate, EmotionType>
) {
    var currentMonth by remember { mutableStateOf(YearMonth.now()) }
    val today = LocalDate.now()

    val firstDayOfMonth = currentMonth.atDay(1)
    val daysInMonth = currentMonth.lengthOfMonth()
    val startDayOfWeek =
        firstDayOfMonth.dayOfWeek.value % 7 // SUNDAY = 0, MONDAY = 1, ..., SATURDAY = 6

    val calendarDays = buildList {
        repeat(startDayOfWeek) { add(null) }
        for (day in 1..daysInMonth) {
            val date = currentMonth.atDay(day)
            add(CalendarDay(date, recordData[date]))
        }
    }

    Column(
        modifier = Modifier
            .border(1.dp, Gray300, RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        // 월 이동 바
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { currentMonth = currentMonth.minusMonths(1) }) {
                Icon(
                    painter = painterResource(R.drawable.ic_calendar_arrow_left),
                    contentDescription = "Previous Month",
                    tint = Color.Unspecified
                )
            }

            Text(
                text = stringResource(
                    R.string.year_month,
                    currentMonth.year,
                    currentMonth.monthValue
                ),
                style = CodiOnTypography.pretendard_500_16,
                color = Gray700
            )

            IconButton(onClick = { currentMonth = currentMonth.plusMonths(1) }) {
                Icon(
                    painter = painterResource(R.drawable.ic_calendar_arrow_right),
                    contentDescription = "Next Month",
                    tint = Color.Unspecified
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 요일 헤더
        val weekDays = listOf("S", "M", "T", "W", "T", "F", "S")
        Row(Modifier.fillMaxWidth()) {
            weekDays.forEachIndexed { index, day ->
                val color = when (index) {
                    0 -> Color.Red
                    6 -> Color.Blue
                    else -> Color.Unspecified
                }
                Text(
                    day,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    color = color
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 날짜 격자
        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            userScrollEnabled = false
        ) {
            items(calendarDays.size) { index ->
                val day = calendarDays.getOrNull(index)

                if (day == null) {
                    Box(modifier = Modifier.size(44.dp)) // 빈 칸
                } else {
                    val isToday = day.date == today

                    Column(
                        modifier = Modifier
                            .size(44.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = day.date.dayOfMonth.toString(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    if (isToday) Gray300 else Color.Transparent,
                                    shape = CircleShape
                                ),
                            textAlign = TextAlign.Center,
                        )

                        Box(
                            modifier = Modifier.size(44.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            day.emotion?.let {
                                Icon(
                                    painter = painterResource(id = getEmotionIcon(it)),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp),
                                    tint = Color.Unspecified
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CodiRecordCalendarPreview() {
    val mockData = CalendarDay.dummyData.toMap()
    CodiRecordCalendar(recordData = mockData)
}