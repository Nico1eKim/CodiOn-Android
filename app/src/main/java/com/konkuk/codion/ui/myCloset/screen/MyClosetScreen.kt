package com.konkuk.codion.ui.myCloset.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.common.ClothesCardComponent
import com.konkuk.codion.ui.common.TopAppBarComponent
import com.konkuk.codion.ui.common.dummy.ClothesCardDummyData
import com.konkuk.codion.ui.common.filter.FilterBottomSheetList
import com.konkuk.codion.ui.common.filter.FilterButton
import com.konkuk.codion.ui.common.filter.FilterType
import com.konkuk.codion.ui.common.filter.PersonalColorType
import com.konkuk.codion.ui.common.filter.SortDropdown
import com.konkuk.codion.ui.common.filter.SortType
import com.konkuk.codion.ui.myCloset.ClothesCategoryType
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun MyClosetScreen() {
    val topLevelTabs = ClothesCategoryType.getTopLevelCategories()
    var selectedTab by remember { mutableStateOf(topLevelTabs.first()) }

// 필터 상태
    val appliedCategoryOptions = remember { mutableStateListOf<ClothesCategoryType>() }
    val appliedPersonalColorOptions = remember { mutableStateListOf<PersonalColorType>() }

    val tempCategoryOptions = remember { mutableStateListOf<ClothesCategoryType>() }
    val tempPersonalColorOptions = remember { mutableStateListOf<PersonalColorType>() }

    var expandedSheet by remember { mutableStateOf<FilterType?>(null) }

    val allClothes = ClothesCardDummyData.dummyData

    val filteredClothes = allClothes.filter { item ->
        val matchCategory =
            appliedCategoryOptions.isEmpty() || appliedCategoryOptions.contains(item.clothesType)
        val matchPersonalColor =
            appliedPersonalColorOptions.isEmpty() || appliedPersonalColorOptions.contains(item.clothesPersonalColor)
        val matchTopTab =
            selectedTab == ClothesCategoryType.ALL || item.clothesType.parent == selectedTab

        matchCategory && matchPersonalColor && matchTopTab
    }

    // sort
    val options = SortType.entries
    var selectedOption by rememberSaveable { mutableStateOf(SortType.FREQUENCY) }

    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = stringResource(R.string.my_closet),
                leftIcon = null,
                onLeftClicked = null,
                rightIcon = painterResource(R.drawable.ic_add),
                onRightClicked = {
//                    TODO: 화면 이동 구현
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            ScrollableTabRow(
                selectedTabIndex = topLevelTabs.indexOf(selectedTab),
                edgePadding = 0.dp
            ) {
                topLevelTabs.forEachIndexed { index, tab ->
                    Tab(
                        selected = selectedTab == tab,
                        onClick = { selectedTab = tab },
                        text = {
                            Text(
                                text = tab.label,
                                style = CodiOnTypography.pretendard_400_16,
                                color = Gray700
                            )
                        },
                        selectedContentColor = Gray700,
                    )
                }
            }

            FilterBottomSheetList(
                selectedParentCategory = selectedTab,
                selectedCategoryOptions = tempCategoryOptions,
                selectedPersonalColorOptions = tempPersonalColorOptions,
                onClick = {
                    appliedCategoryOptions.clear()
                    appliedCategoryOptions.addAll(tempCategoryOptions)

                    appliedPersonalColorOptions.clear()
                    appliedPersonalColorOptions.addAll(tempPersonalColorOptions)

                    expandedSheet = null
                },
                expandedSheet = expandedSheet,
                onDismiss = { expandedSheet = null },
                onOpenSheet = { expandedSheet = it }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // 적용된 필터 목록
                LazyRow(
                    modifier = Modifier
                        .width(256.dp),
                ) {
                    items(appliedCategoryOptions) { category ->
                        FilterButton(
                            filterLabel = category.label,
                            onClose = {
                                appliedCategoryOptions.remove(category)
                                tempCategoryOptions.remove(category)
                            }
                        )
                    }
                    items(appliedPersonalColorOptions) { color ->
                        FilterButton(
                            filterLabel = color.label,
                            onClose = {
                                appliedPersonalColorOptions.remove(color)
                                tempPersonalColorOptions.remove(color)
                            }
                        )
                    }
                }

                SortDropdown(
                    options = options.map { it.label },
                    selectedOption = selectedOption.label,
                ) { selectedLabel ->
                    selectedOption = options.first { it.label == selectedLabel }
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(horizontal = 20.dp),
            ) {
                items(filteredClothes) { item ->
                    ClothesCardComponent(clothesData = item, isClickable = true, isSelected = false)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MyClosetScreenPreview() {
    MyClosetScreen()
}