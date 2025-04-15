package com.konkuk.codion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.konkuk.codion.ui.navigator.MainNavGraph
import com.konkuk.codion.ui.theme.CodiOnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            var showSplash by remember { mutableStateOf(true) }
            val navController = rememberNavController()

            CodiOnTheme {
//                if (showSplash) {
//                    SplashScreen {
//                        showSplash = false
//                    }
//                } else {
                     MainNavGraph(navController = navController)
//                }
            }
        }
    }
}