package com.konkuk.codion.ui.common.dummy

import androidx.annotation.DrawableRes
import com.konkuk.codion.R
import com.konkuk.codion.ui.common.filter.PersonalColorType
import com.konkuk.codion.ui.myCloset.ClothesCategoryType

data class ClothesCardDummyData(
    @DrawableRes val clothesImg: Int,
    val wearCount: Int,
    val isHeartClicked: Boolean,
    val clothesName: String,
    val clothesPersonalColor: PersonalColorType,
    val clothesType: ClothesCategoryType,
    val chipList: List<Int> = listOf()
) {
    companion object {
        val dummyData = listOf(
            ClothesCardDummyData(
                clothesImg = R.drawable.img_clothes_example,
                wearCount = 5,
                isHeartClicked = false,
                clothesName = "갈색 가디건",
                clothesPersonalColor = PersonalColorType.AUTUMN_WARM,
                clothesType = ClothesCategoryType.CARDIGAN,
                chipList = listOf(
                    R.string.chip_date,
                    R.string.chip_casual,
                    R.string.chip_travel
                )
            ),
            ClothesCardDummyData(
                clothesImg = R.drawable.img_clothes_example2,
                wearCount = 2,
                isHeartClicked = false,
                clothesName = "코듀로이 팬츠",
                clothesPersonalColor = PersonalColorType.AUTUMN_WARM,
                clothesType = ClothesCategoryType.LONG_PANTS,
                chipList = listOf(
                    R.string.chip_date,
                    R.string.chip_casual,
                    R.string.chip_business
                )
            ),
            ClothesCardDummyData(
                clothesImg = R.drawable.img_clothes_example3,
                wearCount = 1,
                isHeartClicked = false,
                clothesName = "레더 자켓",
                clothesPersonalColor = PersonalColorType.WINTER_COOL,
                clothesType = ClothesCategoryType.JACKET,
                chipList = listOf(
                    R.string.chip_casual,
                    R.string.chip_travel
                )
            ),
            ClothesCardDummyData(
                clothesImg = R.drawable.img_clothes_example4,
                wearCount = 0,
                isHeartClicked = false,
                clothesName = "청바지",
                clothesPersonalColor = PersonalColorType.SUMMER_COOL,
                clothesType = ClothesCategoryType.LONG_PANTS,
                chipList = listOf(
                    R.string.chip_date,
                    R.string.chip_casual,
                    R.string.chip_travel,
                    R.string.chip_business
                )
            ),
            ClothesCardDummyData(
                clothesImg = R.drawable.img_clothes_example5,
                wearCount = 3,
                isHeartClicked = false,
                clothesName = "라인이 있는 청바지",
                clothesPersonalColor = PersonalColorType.SPRING_WARM,
                clothesType = ClothesCategoryType.LONG_PANTS,
                chipList = listOf(
                    R.string.chip_date,
                    R.string.chip_casual,
                )
            ),
            ClothesCardDummyData(
                clothesImg = R.drawable.img_clothes_example6,
                wearCount = 2,
                isHeartClicked = false,
                clothesName = "갈색 미디 원피스",
                clothesPersonalColor = PersonalColorType.AUTUMN_WARM,
                clothesType = ClothesCategoryType.MIDI,
                chipList = listOf(
                    R.string.chip_date,
                )
            ),
            ClothesCardDummyData(
                clothesImg = R.drawable.img_clothes_example7,
                wearCount = 2,
                isHeartClicked = false,
                clothesName = "스커트",
                clothesPersonalColor = PersonalColorType.SPRING_WARM,
                clothesType = ClothesCategoryType.LONG,
                chipList = listOf(
                    R.string.chip_date,
                    R.string.chip_casual,
                )
            ),
            ClothesCardDummyData(
                clothesImg = R.drawable.img_clothes_example8,
                wearCount = 1,
                isHeartClicked = false,
                clothesName = "아우터",
                clothesPersonalColor = PersonalColorType.SPRING_WARM,
                clothesType = ClothesCategoryType.JACKET,
                chipList = listOf(
                    R.string.chip_casual,
                )
            )
        )
    }
}
