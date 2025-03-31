package com.konkuk.codion.ui.common.filter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilterBottomSheetList(modifier: Modifier = Modifier) {
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

    // 바텀시트 (필터와는 별도로 보여짐)
    if (expandedSheet != null) {
        FilterBottomSheet(
            expandedSheet = expandedSheet!!,
            onDismiss = { expandedSheet = null }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterBottomSheet(
    expandedSheet: FilterType,
    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var selectedTab by remember { mutableStateOf(expandedSheet) }

//    val tabs = listOf("카테고리", "퍼스널컬러", "색상", "상황", "즐겨찾기 여부")

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.fillMaxHeight(0.85f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            // 타이틀
            Text(
                text = "필터",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // 탭 리스트
            LazyRow(
                contentPadding = PaddingValues(horizontal = 0.dp),
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                items(FilterType.entries) { tab ->
                    Text(
                        text = tab.label,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable { selectedTab = tab },
                        color = if (tab == selectedTab) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 선택된 탭에 따른 콘텐츠
            when (selectedTab) {
                FilterType.CATEGORY -> CategoryFilter()
                FilterType.PERSONAL_COLOR -> PersonalColorFilter()
                FilterType.COLOR -> Text("색상 필터 콘텐츠")
                FilterType.SITUATION -> Text("상황 필터 콘텐츠")
                FilterType.BOOKMARKED -> Text("즐겨찾기 여부 콘텐츠")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onDismiss,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "42,867개의 상품보기")
            }
        }
    }
}

@Composable
fun CategoryFilter(modifier: Modifier = Modifier) {
    val selectedOptions = remember { mutableStateListOf<CategoryType>() }

    Column {
        CategoryType.entries.forEach { option ->
            val isSelected = option in selectedOptions

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        if (isSelected) selectedOptions.remove(option)
                        else selectedOptions.add(option)
                    }
                    .padding(vertical = 8.dp)
            ) {
                Checkbox(
                    checked = isSelected,
                    onCheckedChange = {
                        if (it) selectedOptions.add(option)
                        else selectedOptions.remove(option)
                    }
                )
                Text(
                    text = option.label,
                    modifier = Modifier.padding(start = 8.dp),
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun PersonalColorFilter() {
    var selected by remember { mutableStateOf<PersonalColorType?>(null) }

    Column {
        PersonalColorType.entries.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selected = option }
                    .padding(vertical = 8.dp)
            ) {
                RadioButton(
                    selected = selected == option,
                    onClick = { selected = option }
                )
                Text(
                    text = option.label,
                    modifier = Modifier.padding(start = 8.dp),
                    fontSize = 16.sp
                )
            }
        }
    }
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