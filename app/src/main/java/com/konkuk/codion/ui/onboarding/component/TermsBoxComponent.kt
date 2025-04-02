package com.konkuk.codion.ui.onboarding.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.onboarding.dummy.TermsDummyData
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray500
import com.konkuk.codion.ui.theme.Gray700

// 모든 약관이 담긴 박스
@Composable
fun TermsBoxComponent() {
    val termsList = remember {
        mutableStateListOf(*TermsDummyData.dummyData.toTypedArray())
    }
    val allIndex = termsList.indexOfFirst { it.isAllAgreement }
    val lastIndividualIndex = termsList.indexOfLast { !it.isAllAgreement }

    val onCheckChanged: (index: Int, Boolean) -> Unit = { index, checked ->
        termsList[index] = termsList[index].copy(isChecked = checked)

        if (index == allIndex) {
            // 전체 동의 → 하위 항목 전체 변경
            termsList.forEachIndexed { i, item ->
                if (!item.isAllAgreement) {
                    termsList[i] = item.copy(isChecked = checked)
                }
            }
        } else {
            // 개별 항목 → 전체 동의 여부 판단
            val allChecked = termsList
                .filter { !it.isAllAgreement }
                .all { it.isChecked }

            termsList[allIndex] = termsList[allIndex].copy(isChecked = allChecked)
        }
    }

    Column(
        modifier = Modifier
            .border(1.dp, Gray700, shape = RoundedCornerShape(6.dp))
            .padding(14.dp)
    ) {
        // 전체 동의 항목
        TermsItemComponent(
            data = termsList[allIndex],
            onCheckedChange = { checked -> onCheckChanged(allIndex, checked) }
        )

        Spacer(modifier = Modifier.height(10.dp))

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = Gray700
        )

        Spacer(modifier = Modifier.height(10.dp))

        // 개별 항목
        termsList.forEachIndexed { index, item ->
            if (!item.isAllAgreement) {
                TermsItemComponent(
                    data = item,
                    onCheckedChange = { checked ->
                        onCheckChanged(index, checked)
                    }
                )

                // 마지막 항목이 아니면 Spacer 추가
                if (index != lastIndividualIndex) {
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

// 약관 한 줄에 대한 컴포넌트
@Composable
fun TermsItemComponent(
    data: TermsDummyData,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomCheckbox(
            checked = data.isChecked,
            onCheckedChange = onCheckedChange
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = (if (data.isRequired) "[필수] " else "[선택] ") + data.label,
            style = CodiOnTypography.pretendard_400_14,
            color = Gray700
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "보기",
            style = CodiOnTypography.pretendard_400_12.copy(
                textDecoration = TextDecoration.Underline
            ),
            color = Gray500,
            modifier = Modifier.clickable {
                // TODO: 약관 상세 보기 처리
            }
        )
    }
}

// 커스텀 Checkbox
@Composable
fun CustomCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    IconToggleButton(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = Modifier
            .size(18.dp)
    ) {
        Icon(
            painter = if (checked) painterResource(R.drawable.ic_checkbox_selected) else painterResource(
                R.drawable.ic_checkbox_unselected
            ),
            contentDescription = "커스텀 체크박스",
            tint = Color.Unspecified
        )
    }
}

@Preview
@Composable
fun TermsBoxComponentPreview() {
    TermsBoxComponent()
}