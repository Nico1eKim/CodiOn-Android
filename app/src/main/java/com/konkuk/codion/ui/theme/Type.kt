package com.konkuk.codion.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.konkuk.codion.R

val PretendardBold = FontFamily(Font(R.font.bold)) // weight 700
val PretendardSemiBold = FontFamily(Font(R.font.semibold)) // weight 600
val PretendardMedium = FontFamily(Font(R.font.medium)) // weight 500
val PretendardRegular = FontFamily(Font(R.font.regular)) // weight 400

object CodiOnTypography {
    val pretendard_700_64 = TextStyle(
        fontFamily = PretendardBold,
        fontSize = 64.sp
    )

    val pretendard_700_16 = TextStyle(
        fontFamily = PretendardBold,
        fontSize = 16.sp
    )

    val pretendard_600_20 = TextStyle(
        fontFamily = PretendardSemiBold,
        fontSize = 20.sp
    )

    val pretendard_600_16 = TextStyle(
        fontFamily = PretendardSemiBold,
        fontSize = 16.sp
    )

    val pretendard_600_14 = TextStyle(
        fontFamily = PretendardSemiBold,
        fontSize = 14.sp
    )

    val pretendard_600_12 = TextStyle(
        fontFamily = PretendardSemiBold,
        fontSize = 12.sp
    )

    val pretendard_500_16 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 16.sp
    )

    val pretendard_500_14 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 14.sp
    )

    val pretendard_500_12 = TextStyle(
        fontFamily = PretendardRegular,
        fontSize = 12.sp
    )

    val pretendard_500_10 = TextStyle(
        fontFamily = PretendardRegular,
        fontSize = 10.sp
    )

    val pretendard_400_16 = TextStyle(
        fontFamily = PretendardRegular,
        fontSize = 16.sp
    )

    val pretendard_400_14 = TextStyle(
        fontFamily = PretendardRegular,
        fontSize = 14.sp
    )

    val pretendard_400_12 = TextStyle(
        fontFamily = PretendardRegular,
        fontSize = 12.sp
    )
}