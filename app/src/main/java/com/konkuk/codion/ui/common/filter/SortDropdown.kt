package com.konkuk.codion.ui.common.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray400
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun SortDropdown(
    options: List<String>,
    selectedOption: String,
    onSelectedOptionChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .width(88.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Row(
            modifier = Modifier.clickable {
                expanded = true
            },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = selectedOption,
                style = CodiOnTypography.pretendard_400_12,
                color = Gray400
            )

            Icon(
                painter = if (expanded) painterResource(id = R.drawable.ic_sort_dropdown_up) else painterResource(
                    id = R.drawable.ic_sort_dropdown
                ),
                tint = Color.Unspecified,
                contentDescription = "Expand Down"
            )
        }

        DropdownMenu(
            modifier = Modifier
                .width(100.dp)
                .background(color = Gray100, shape = RoundedCornerShape(8.dp)),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                val isSelected = option == selectedOption

                DropdownMenuItem(
                    modifier = Modifier
                        .width(100.dp),
                    text = {
                        Text(
                            text = option,
                            style = CodiOnTypography.pretendard_500_14.copy(
                                color = if (isSelected) Gray700 else Gray400
                            )
                        )
                    },
                    onClick = {
                        onSelectedOptionChange(option)
                    }
                )
            }
        }
    }

}