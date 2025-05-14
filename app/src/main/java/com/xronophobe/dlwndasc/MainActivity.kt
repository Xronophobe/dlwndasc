package com.xronophobe.dlwndasc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.xronophobe.dlwndasc.ui.theme.DlwndascTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DlwndascTheme {
                AppRoot()
            }
        }
    }
}

@Composable
fun AppRoot() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = FirstDestination,
    ) {
        composable<FirstDestination>{
            FirstScreen()
        }
        composable<SecondDestination>(
            deepLinks = listOf(
                navDeepLink<SecondDestination>(
                    basePath = "https://dlwndasc/timeline"
                )
            )
        ) {
            SecondScreen()
        }
    }
}

@Serializable
data object FirstDestination

@Serializable
data object SecondDestination
