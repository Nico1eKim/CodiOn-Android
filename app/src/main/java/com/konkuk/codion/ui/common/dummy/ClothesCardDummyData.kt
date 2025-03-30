package com.konkuk.codion.ui.common.dummy

import androidx.annotation.DrawableRes
import com.konkuk.codion.R

data class ClothesCardDummyData(
    @DrawableRes val clothesImg: Int,
    val wearCount: Int,
    val isHeartClicked: Boolean,
    val clothesName: String,
    val clothesPersonalColor: String,
    val chipList: List<Int> = listOf()
) {
    companion object {
        val dummyData = listOf(
            ClothesCardDummyData(
                clothesImg = R.drawable.img_clothes_example,
                wearCount = 5,
                isHeartClicked = false,
                clothesName = "갈색 가디건",
                clothesPersonalColor = "가을 웜",
                chipList = listOf(
                    R.string.chip_date,
                    R.string.chip_casual,
                    R.string.chip_travel
                )
            ),
            ClothesCardDummyData(
                clothesImg = R.drawable.img_clothes_example,
                wearCount = 5,
                isHeartClicked = false,
                clothesName = "갈색 가디건",
                clothesPersonalColor = "가을 웜",
                chipList = listOf(
                    R.string.chip_date,
                    R.string.chip_casual,
                    R.string.chip_travel
                )
            ),
            ClothesCardDummyData(
                clothesImg = R.drawable.img_clothes_example,
                wearCount = 5,
                isHeartClicked = false,
                clothesName = "갈색 가디건",
                clothesPersonalColor = "가을 웜",
                chipList = listOf(
                    R.string.chip_date,
                    R.string.chip_casual,
                    R.string.chip_travel
                )
            ),
            ClothesCardDummyData(
                clothesImg = R.drawable.img_clothes_example,
                wearCount = 5,
                isHeartClicked = false,
                clothesName = "갈색 가디건",
                clothesPersonalColor = "가을 웜",
                chipList = listOf(
                    R.string.chip_date,
                    R.string.chip_casual,
                    R.string.chip_travel
                )
            ),
            ClothesCardDummyData(
                clothesImg = R.drawable.img_clothes_example,
                wearCount = 5,
                isHeartClicked = false,
                clothesName = "갈색 가디건",
                clothesPersonalColor = "가을 웜",
                chipList = listOf(
                    R.string.chip_date,
                    R.string.chip_casual,
                    R.string.chip_travel
                )
            )
        )

    }
}
