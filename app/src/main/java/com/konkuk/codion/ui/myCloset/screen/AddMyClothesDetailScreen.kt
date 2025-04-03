package com.konkuk.codion.ui.myCloset.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konkuk.codion.R
import com.konkuk.codion.ui.common.ChipComponent
import com.konkuk.codion.ui.common.ColorWithText
import com.konkuk.codion.ui.common.DropdownComponent
import com.konkuk.codion.ui.common.TopAppBarComponent
import com.konkuk.codion.ui.common.buttons.BigButtonComponent
import com.konkuk.codion.ui.common.dummy.ClothesCardDummyData
import com.konkuk.codion.ui.common.inputFields.InputFieldComponent
import com.konkuk.codion.ui.myCloset.component.OutlineButton
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray200
import com.konkuk.codion.ui.theme.Gray700
import com.konkuk.codion.ui.theme.Gray900

@Composable
fun AddMyClothesDetailScreen(modifier: Modifier = Modifier) {
    val clothesData = ClothesCardDummyData.dummyData[0]
    val clothesNickname by rememberSaveable { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf<String?>(null) }
    var selectedPersonalColor by remember { mutableStateOf<String?>(null) }
    var selectedColor by remember { mutableStateOf<ColorWithText?>(null) }

    var canWearState by remember { mutableStateOf<Boolean?>(null) }

    val availableChips = listOf(
        stringResource(id = R.string.chip_date),
        stringResource(id = R.string.chip_casual),
        stringResource(id = R.string.chip_travel),
        stringResource(id = R.string.chip_workout),
        stringResource(id = R.string.chip_business)
    )

    val selectedChips = remember { mutableStateOf(setOf<String>()) }

    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = stringResource(R.string.add_clothes),
                leftIcon = painterResource(R.drawable.ic_back),
                onLeftClicked = {
//                    TODO: 뒤로가기 구현
                },
                rightIcon = null,
                onRightClicked = null
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 50.dp)
                        .size(width = 148.dp, height = 196.dp)
                        .clip(shape = RoundedCornerShape(12.dp))
                        .background(color = Gray200),
                ) {
                    Image(
                        painter = painterResource(id = clothesData.clothesImg),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            InputFieldComponent(
                label = stringResource(R.string.nickname),
                isRequired = true,
                placeholder = stringResource(R.string.nickname_ph),
                inputText = clothesNickname,
            )

            Text(
                text = stringResource(R.string.category),
                style = CodiOnTypography.pretendard_600_14.copy(
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Center,
                        trim = LineHeightStyle.Trim.None
                    ),
                    lineHeight = 21.sp
                ),
                color = Gray700,
                modifier = Modifier.padding(top = 20.dp, bottom = 4.dp)
            )

            DropdownComponent(
                placeholder = stringResource(R.string.category_placeholder),
                options = listOf("상의", "아우터", "바지", "원피스/스커트"),
                selectedOption = selectedCategory,
                onOptionSelected = { selectedCategory = it }
            )

            Text(
                text = stringResource(R.string.personal_color_color),
                style = CodiOnTypography.pretendard_600_14.copy(
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Center,
                        trim = LineHeightStyle.Trim.None
                    ),
                    lineHeight = 21.sp
                ),
                color = Gray700,
                modifier = Modifier.padding(top = 20.dp, bottom = 4.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                DropdownComponent(
                    modifier = Modifier.weight(1f),
                    placeholder = stringResource(R.string.personal_color_placeholder),
                    options = listOf("봄 웜", "여름 쿨", "가을 웜", "겨울 쿨"),
                    selectedOption = selectedPersonalColor,
                    onOptionSelected = { selectedPersonalColor = it }
                )

                Spacer(modifier = Modifier.width(12.dp))

                DropdownComponent(
                    modifier = Modifier.weight(1f),
                    placeholder = stringResource(R.string.color_placeholder),
                    options = listOf(
                        ColorWithText(Color(0xFF8B4513), "갈색"),
                        ColorWithText(Color.Red, "빨강"),
                        ColorWithText(Color.Yellow, "노랑")
                    ),
                    selectedOption = selectedColor,
                    onOptionSelected = { selectedColor = it }
                )
            }

            Text(
                text = stringResource(R.string.can_wear_in_rain),
                style = CodiOnTypography.pretendard_600_14.copy(
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Center,
                        trim = LineHeightStyle.Trim.None
                    ),
                    lineHeight = 21.sp
                ),
                color = Gray700,
                modifier = Modifier.padding(top = 20.dp, bottom = 4.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlineButton(
                    modifier = Modifier.weight(1f),
                    label = stringResource(R.string.can_wear),
                    isClicked = canWearState == true,
                ) {
                    canWearState = if (canWearState == true) null else true
                }

                Spacer(modifier = Modifier.width(12.dp))

                OutlineButton(
                    modifier = Modifier.weight(1f),
                    label = stringResource(R.string.cant_wear),
                    isClicked = canWearState == false,
                ) {
                    canWearState = if (canWearState == false) null else false
                }
            }

            Text(
                text = stringResource(R.string.occasion_keyword),
                style = CodiOnTypography.pretendard_600_14.copy(
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Center,
                        trim = LineHeightStyle.Trim.None
                    ),
                    lineHeight = 21.sp
                ),
                color = Gray700,
                modifier = Modifier.padding(top = 20.dp, bottom = 4.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                availableChips.forEach { chipText ->
                    val isSelected = selectedChips.value.contains(chipText)

                    ChipComponent(
                        chipText = chipText,
                        isSelected = isSelected,
                        onClick = {
                            selectedChips.value = if (isSelected) {
                                selectedChips.value - chipText
                            } else {
                                selectedChips.value + chipText
                            }
                        }
                    )

                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            BigButtonComponent(
                containerColor = Gray900,
                contentColor = Gray100,
                text = stringResource(R.string.finish_clothes_upload)
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AddMyClothesDetailScreenPreview() {
    AddMyClothesDetailScreen()
}