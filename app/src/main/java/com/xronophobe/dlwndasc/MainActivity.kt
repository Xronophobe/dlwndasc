package com.xronophobe.dlwndasc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
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
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet() {
                NavigationDrawerItem(
                    label = { Text(text="One") },
                    selected = false,
                    onClick = {},
                )
            }
        },
    ) {
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
                        basePath = "dlwndasc://linked-items"
                    )
                )
            ) { backStackEntry ->
                val input = backStackEntry.toRoute<SecondDestination>()
                println(input)
                SecondScreen(input.itemId)
            }
        }
    }
}

@Serializable
data object FirstDestination

@Serializable
data class SecondDestination(
    val itemId: String
)


@Preview(showBackground = true)
@Composable()
fun AppRootPreview() {
    DlwndascTheme {
        AppRoot()
    }
}