package com.konkuk.codion.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray500
import com.konkuk.codion.ui.theme.Gray700
import com.konkuk.codion.ui.theme.Red
import com.konkuk.codion.ui.theme.Yellow

data class ColorWithText(val color: Color, val text: String)  // 색상 + 텍스트

// 두 드롭다운에서 공통인 부분 추출한 함수
@Composable
fun <T> GenericDropdownComponent(
    width: Dp,  // 드롭다운 박스 너비
    placeholder: String,  // 선택되지 않았을 때 표시할 텍스트
    options: List<T>,  // 드롭다운 메뉴에 보이는 항목 리스트
    selectedOption: T?,  // 현재 선택된 항목 값
    onOptionSelected: (T) -> Unit,  // 항목 선택 시 호출할 콜백 함수
    optionContent: @Composable (T) -> Unit  // 항목이 표현되는 UI
) {
    // 드롭다운 확장 여부
    var expanded by remember { mutableStateOf(false) }

    val dropdownIcon = painterResource(id = R.drawable.ic_dropdown)

    Box(
        modifier = Modifier
            .clickable { expanded = true }  // 클릭 시 드롭다운 열림
            .width(width)
            .height(40.dp)
            .border(width = 1.dp, color = Gray500, shape = RoundedCornerShape(6.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.CenterStart
            ) {
                // placeholder 노출 여부
                if (selectedOption == null) {
                    Text(
                        text = placeholder,
                        style = CodiOnTypography.pretendard_400_14,
                        color = Gray500
                    )
                } else {
                    optionContent(selectedOption)
                }
            }
            Icon(
                painter = dropdownIcon,
                contentDescription = "드롭다운 아이콘",
                tint = Color.Unspecified
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        optionContent(option)
                    },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

// 텍스트 값이 존재하는 드롭다운
@Composable
fun DropdownComponent(
    width: Dp,
    placeholder: String,
    options: List<String>,
    selectedOption: String?,
    onOptionSelected: (String) -> Unit
) {
    GenericDropdownComponent(
        width = width,
        placeholder = placeholder,
        options = options,
        selectedOption = selectedOption,
        onOptionSelected = onOptionSelected,
        optionContent = { option ->
            Text(
                text = option,
                style = CodiOnTypography.pretendard_400_14,
                color = Gray700
            )
        }
    )
}

// 색상 + 텍스트 값이 존재하는 드롭다운
@Composable
fun DropdownComponent(
    width: Dp,
    placeholder: String,
    options: List<ColorWithText>,
    selectedOption: ColorWithText?,
    onOptionSelected: (ColorWithText) -> Unit
) {
    GenericDropdownComponent(
        width = width,
        placeholder = placeholder,
        options = options,
        selectedOption = selectedOption,
        onOptionSelected = onOptionSelected,
        optionContent = { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .background(
                            color = option.color,
                            shape = RoundedCornerShape(percent = 50)
                        )
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = option.text,
                    style = CodiOnTypography.pretendard_400_14,
                    color = Gray700
                )
            }
        }
    )
}

@Preview
@Composable
fun DropdownComponentPreview() {
    var selectedCategory by remember { mutableStateOf<String?>(null) }
    var selectedTone by remember { mutableStateOf<String?>(null) }
    var selectedColor by remember { mutableStateOf<ColorWithText?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Center
    ) {
        DropdownComponent(
            width = 320.dp,
            placeholder = "카테고리 선택",
            options = listOf("상의", "아우터", "바지", "원피스/스커트"),
            selectedOption = selectedCategory,
            onOptionSelected = { selectedCategory = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        DropdownComponent(
            width = 154.dp,
            placeholder = "퍼스널컬러 선택",
            options = listOf("봄 웜", "여름 쿨", "가을 웜", "겨울 쿨"),
            selectedOption = selectedTone,
            onOptionSelected = { selectedTone = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        DropdownComponent(
            width = 154.dp,
            placeholder = "색상 선택",
            options = listOf(
                ColorWithText(Red, "빨강"),
                ColorWithText(Yellow, "노랑")
            ),
            selectedOption = selectedColor,
            onOptionSelected = { selectedColor = it }
        )
    }
}