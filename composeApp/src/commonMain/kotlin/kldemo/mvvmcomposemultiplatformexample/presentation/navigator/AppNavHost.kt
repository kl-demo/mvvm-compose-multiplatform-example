package kldemo.mvvmcomposemultiplatformexample.presentation.navigator

import androidx.compose.runtime.Composable
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kldemo.mvvmcomposemultiplatformexample.data.api.PlatformApiComponent
import kldemo.mvvmcomposemultiplatformexample.data.api.create
import kldemo.mvvmcomposemultiplatformexample.data.platform.PlatformDataComponent
import kldemo.mvvmcomposemultiplatformexample.data.platform.create
import kldemo.mvvmcomposemultiplatformexample.domain.platform.PlatformManagerComponent
import kldemo.mvvmcomposemultiplatformexample.domain.platform.create
import kldemo.mvvmcomposemultiplatformexample.presentation.platform.PlatformScreen
import kldemo.mvvmcomposemultiplatformexample.presentation.platform.PlatformViewModel
import kldemo.mvvmcomposemultiplatformexample.presentation.start.StartScreen
import kldemo.mvvmcomposemultiplatformexample.presentation.start.StartViewModel

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
            StartScreen(viewModel {
                StartViewModel(NavigatorComponent.instance.appNavigator)
            })
        }
        composable<Screen.Platform> {
            PlatformScreen(viewModel {
                PlatformViewModel(
                    PlatformManagerComponent::class.create(
                        PlatformDataComponent::class.create(
                            PlatformApiComponent::class.create()
                        )
                    ).platformManager,
                    NavigatorComponent.instance.appNavigator,
                    createSavedStateHandle()
                )
            })
        }
    }
}