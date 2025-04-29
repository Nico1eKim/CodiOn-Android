package com.konkuk.codion.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.konkuk.codion.ui.codiRecord.navigation.navigateToCodiRecord
import com.konkuk.codion.ui.home.navigation.navigateToHome
import com.konkuk.codion.ui.myCloset.navigation.navigateToAddMyClothesPicture
import com.konkuk.codion.ui.myCloset.navigation.navigateToMyCloset

class MainNavController(
    val navController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination = MainTabRoute.Home // TODO: Landing으로 바꾸기

    val currentTab: MainTab?
        @Composable get() = MainTab.entries.find { tab ->
            currentDestination?.route == tab.route::class.qualifiedName
        }

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            popUpTo(MainTab.HOME.route) {
                inclusive = false
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTab.HOME -> navController.navigateToHome(navOptions)
            MainTab.CODI_RECORD -> navController.navigateToCodiRecord(navOptions)
            MainTab.MY_CLOSET -> navController.navigateToMyCloset(navOptions)
            MainTab.MY_PAGE -> navController.navigateToMyCloset(navOptions)
//            MainTab.MY_PAGE -> navController.navigateToMyPage(navOptions) // TODO: 위에 있는 MyPage 이거로 변경
        }
    }

    // Back Pressed
    fun navigateUp() {
        navController.navigateUp()
    }

    fun navigateToAddMyClothesPicture() {
        navController.navigateToAddMyClothesPicture()
    }

    @Composable
    fun shouldShowBottomBar(): Boolean = MainTab.contains {
        currentDestination?.route?.startsWith(it::class.qualifiedName!!) == true
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavController = remember(navController) {
    MainNavController(navController)
}