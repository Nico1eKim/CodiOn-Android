package com.konkuk.codion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.konkuk.codion.ui.common.TopAppBarComponent
import com.konkuk.codion.ui.common.TopAppBarState
import com.konkuk.codion.ui.navigation.MainNavHost
import com.konkuk.codion.ui.navigation.MainTab
import com.konkuk.codion.ui.navigation.component.MainBottomBar
import com.konkuk.codion.ui.navigation.rememberMainNavigator
import com.konkuk.codion.ui.onboarding.screen.SplashScreen
import com.konkuk.codion.ui.theme.CodiOnTheme
import com.konkuk.codion.ui.theme.Gray100
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.collections.immutable.toPersistentList

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var showSplash by remember { mutableStateOf(true) }
            val navController = rememberMainNavigator()
            val topAppBarState =
                remember { mutableStateOf<TopAppBarState?>(null) }

            CodiOnTheme {
                if (showSplash) {
                    SplashScreen {
                        showSplash = false
                    }
                }
                Scaffold(
                    topBar = {
                        topAppBarState.value?.let { state ->
                            TopAppBarComponent(
                                title = state.titleId?.let { stringResource(it) } ?: "",
                                leftIcon = state.leftIconId?.let { painterResource(it) },
                                onLeftClicked = state.onLeftClicked,
                                rightIcon = state.rightIconId?.let { painterResource(it) },
                                onRightClicked = state.onRightClicked
                            )
                        }
                    },
                    bottomBar = {
                        MainBottomBar(
                            modifier = Modifier
                                .background(Gray100)
                                .navigationBarsPadding(),
                            visible = navController.shouldShowBottomBar(),
                            tabs = MainTab.entries.toPersistentList(),
                            currentTab = navController.currentTab,
                            onTabSelected = { navController.navigate(it) }
                        )
                    },
                    content = { innerPadding ->
                        MainNavHost(
                            navigator = navController,
                            padding = innerPadding,
                            setTopAppBar = { topAppBarState.value = it }
                        )
                    }
                )
            }
        }
    }
}