package com.konkuk.codion.ui.myCloset.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.konkuk.codion.ui.common.filter.FilterType
import com.konkuk.codion.ui.common.filter.PersonalColorType
import com.konkuk.codion.ui.myCloset.ClothesCategoryType
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun MyClosetScreen(modifier: Modifier = Modifier) {
    val topLevelTabs = ClothesCategoryType.getTopLevelCategories()
    var selectedTab by remember { mutableStateOf(topLevelTabs.first()) }

    // 필터 상태
    val appliedCategoryOptions = remember { mutableStateListOf<ClothesCategoryType>() }
    val appliedPersonalColorOptions = remember { mutableStateListOf<PersonalColorType>() }

    val tempCategoryOptions = remember { mutableStateListOf<ClothesCategoryType>() }
    val tempPersonalColorOptions = remember { mutableStateListOf<PersonalColorType>() }

    // 바텀시트 열림 상태
    var expandedSheet by remember { mutableStateOf<FilterType?>(null) }

    val allClothes = ClothesCardDummyData.dummyData

    val filteredClothes = allClothes.filter { item ->
        val matchCategory =
            appliedCategoryOptions.isEmpty() || appliedCategoryOptions.contains(item.clothesType)
        val matchPersonalColor =
            tempPersonalColorOptions.isEmpty() || tempPersonalColorOptions.contains(item.clothesPersonalColor)

        val matchTopTab =
            selectedTab == ClothesCategoryType.ALL || item.clothesType.parent == selectedTab

        matchCategory && matchPersonalColor && matchTopTab
    }

    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = stringResource(R.string.my_closet),
                leftIcon = null,
                onLeftClicked = null,
                rightIcon = painterResource(R.drawable.ic_add),
                onRightClicked = { }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
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

            // TODO: 선택한 목록을 LazyVerticalGrid로 표시

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