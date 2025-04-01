package com.konkuk.codion.ui.common.filter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.ui.myCloset.ClothesCategoryType
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun FilterBottomSheetList(selectedParentCategory: ClothesCategoryType? = null) {
    var expandedSheet by remember { mutableStateOf<FilterType?>(null) }

    val filters = FilterType.entries

    Column(modifier = Modifier.padding(16.dp)) {
        LazyRow(
            contentPadding = PaddingValues(end = 8.dp)
        ) {
            items(filters) { filter ->
                Box(modifier = Modifier.padding(end = 8.dp)) {
                    FilterBottomSheetButton(
                        placeholder = filter.label,
                        onClick = { expandedSheet = filter }
                    )
                }
            }
        }
    }

    if (expandedSheet != null) {
        FilterBottomSheet(
            expandedSheet = expandedSheet!!,
            selectedParentCategory = selectedParentCategory,
        ) { expandedSheet = null }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterBottomSheet(
    expandedSheet: FilterType,
    selectedParentCategory: ClothesCategoryType?,
    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var selectedTab by remember { mutableStateOf(expandedSheet) }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        containerColor = Gray100,
        modifier = Modifier.fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            LazyRow(
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                items(FilterType.entries) { tab ->
                    Text(
                        text = tab.label,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable { selectedTab = tab },
                        color = Gray700,
                        style = if (tab == selectedTab)
                            CodiOnTypography.pretendard_700_16
                        else
                            CodiOnTypography.pretendard_400_16,
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            when (selectedTab) {
                FilterType.CATEGORY -> CategoryFilter(parentCategory = selectedParentCategory)
                FilterType.PERSONAL_COLOR -> PersonalColorFilter()
                else -> Text("아직 구현되지 않은 필터입니다.")
            }

            Spacer(modifier = Modifier.height(24.dp))


        }
    }
}

@Composable
fun CategoryFilter(parentCategory: ClothesCategoryType? = null) {
    val selectedOptions = remember { mutableStateListOf<ClothesCategoryType>() }

    val options = when (parentCategory) {
        null, ClothesCategoryType.ALL -> ClothesCategoryType.entries.filter { it.parent != null }
        else -> ClothesCategoryType.getChildrenOf(parentCategory)
    }

    CheckBoxFilter(
        options = options,
        selectedOptions = selectedOptions,
        labelProvider = { it.label }
    )
}

@Composable
fun PersonalColorFilter() {
    var selected by remember { mutableStateOf<PersonalColorType?>(null) }

    RadioButtonFilter(
        options = PersonalColorType.entries,
        selectedOption = selected,
        onSelect = { selected = it },
        labelProvider = { it.label }
    )
}


@Preview(showBackground = true)
@Composable
private fun FilterBottomSheetListPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        FilterBottomSheetList()
    }
}