package com.konkuk.codion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.konkuk.codion.ui.navigation.MainNavHost
import com.konkuk.codion.ui.navigation.MainTab
import com.konkuk.codion.ui.navigation.component.MainBottomBar
import com.konkuk.codion.ui.navigation.rememberMainNavigator
import com.konkuk.codion.ui.theme.CodiOnTheme
import com.konkuk.codion.ui.theme.Gray100
import kotlinx.collections.immutable.toPersistentList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            var showSplash by remember { mutableStateOf(true) }
            val navController = rememberMainNavigator()

            CodiOnTheme {
//                if (showSplash) {
//                    SplashScreen {
//                        showSplash = false
//                    }
//                } else {
                Scaffold(
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
                            padding = innerPadding
                        )
                    }
                )
//                }
            }
        }
    }
}