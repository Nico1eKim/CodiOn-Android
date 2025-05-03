package com.konkuk.codion.ui.common.filter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray400
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun <T> RadioButtonFilter(
    options: List<T>,
    selectedOption: T?,
    onSelect: (T) -> Unit,
    labelProvider: (T) -> String
) {
    LazyColumn {
        items(options.size) { index ->
            val option = options[index]

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSelect(option) }
                    .padding(vertical = 16.dp, horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = selectedOption == option,
                    modifier =
                        Modifier
                            .size(20.dp),
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Gray700,
                        unselectedColor = Gray400
                    ),
                    onClick = { onSelect(option) }
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
fun RadioButtonFilterPreview() {
    var selected by remember { mutableStateOf<PersonalColorType?>(null) }

    RadioButtonFilter(
        options = PersonalColorType.entries,
        selectedOption = selected,
        onSelect = { selected = it },
        labelProvider = { it.label }
    )
}