package com.konkuk.codion.ui.myCloset.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.common.TopAppBarComponent
import com.konkuk.codion.ui.common.filter.FilterBottomSheetList
import com.konkuk.codion.ui.myCloset.ClothesCategoryType
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun MyClosetScreen(modifier: Modifier = Modifier) {
    val topLevelTabs = ClothesCategoryType.getTopLevelCategories()
    var selectedTab by remember { mutableStateOf(topLevelTabs.first()) }

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
                selectedParentCategory = selectedTab
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MyClosetScreenPreview() {
    MyClosetScreen()
}