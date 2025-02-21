package kldemo.mvvmcomposemultiplatformexample.presentation.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kldemo.mvvmcomposemultiplatformexample.presentation.platform.PlatformScreen
import kldemo.mvvmcomposemultiplatformexample.presentation.start.StartScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    startScreen: Screen
) {
    NavHost(
        navController = navController,
        startDestination = startScreen
    ) {
        composable<Screen.Start> {
            StartScreen()
        }
        composable<Screen.Platform> {
            PlatformScreen()
        }
    }
}