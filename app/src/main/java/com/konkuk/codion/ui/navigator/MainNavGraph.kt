package com.konkuk.codion.ui.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.konkuk.codion.ui.codiRecord.screen.CodiRecordScreen
import com.konkuk.codion.ui.codiRecord.screen.RegisterCodiCommentScreen
import com.konkuk.codion.ui.home.HomeScreen
import com.konkuk.codion.ui.myCloset.screen.AddMyClothesDetailScreen
import com.konkuk.codion.ui.myCloset.screen.AddMyClothesPictureScreen
import com.konkuk.codion.ui.myCloset.screen.MyClosetScreen

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Routes.Home) {
        composable<Routes.Home> {
            HomeScreen(navController = navController)
        }

        // codiRecord
        composable<Routes.CodiRecord> {
            CodiRecordScreen(navController = navController)
        }
        composable<Routes.RegisterCodiComment> {
            RegisterCodiCommentScreen(navController = navController)
        }

        // myCloset
        composable<Routes.MyCloset> {
            MyClosetScreen(navController = navController)
        }
        composable<Routes.AddMyClothesDetail> {
            AddMyClothesDetailScreen(navController = navController)
        }
        composable<Routes.AddMyClothesPicture> {
            AddMyClothesPictureScreen(navController = navController)
        }
    }
}