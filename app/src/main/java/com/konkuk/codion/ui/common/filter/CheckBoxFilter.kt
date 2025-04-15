package com.konkuk.codion.ui.common.filter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.ui.myCloset.ClothesCategoryType
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray400
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun <T> CheckBoxFilter(
    options: List<T>,
    selectedOptions: SnapshotStateList<T>,
    labelProvider: (T) -> String
) {
    LazyColumn {
        items(options.size) { index ->
            val option = options[index]
            val isSelected = option in selectedOptions

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        if (isSelected) selectedOptions.remove(option)
                        else selectedOptions.add(option)
                    }
                    .padding(16.dp)
            ) {
                Checkbox(
                    checked = isSelected,
                    modifier =
                        Modifier
                            .size(20.dp),
                    colors =
                        CheckboxDefaults.colors(
                            checkmarkColor = Gray100,
                            checkedColor = Gray700,
                            uncheckedColor = Gray100,
                        ).copy(
                            checkedBorderColor = Gray700,
                            uncheckedBorderColor = Gray400
                        ),
                    onCheckedChange = {
                        if (it) selectedOptions.add(option)
                        else selectedOptions.remove(option)
                    }
                )
                Text(
                    text = labelProvider(option),
                    modifier = Modifier.padding(start = 12.dp),
                    style = CodiOnTypography.pretendard_500_16,
                    color = Gray700
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckBoxFilterPreview(modifier: Modifier = Modifier) {
    val selectedOptions = remember { mutableStateListOf<ClothesCategoryType>() }

    CheckBoxFilter(
        options = ClothesCategoryType.getChildrenOf(ClothesCategoryType.BOTTOM),
        selectedOptions = selectedOptions,
        labelProvider = { it.label }
    )
}