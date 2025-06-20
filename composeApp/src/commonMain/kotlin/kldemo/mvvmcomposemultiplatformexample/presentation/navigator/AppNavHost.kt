package kldemo.mvvmcomposemultiplatformexample.presentation.navigator

import androidx.compose.runtime.Composable
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kldemo.mvvmcomposemultiplatformexample.data.api.PlatformApiComponent
import kldemo.mvvmcomposemultiplatformexample.data.api.create
import kldemo.mvvmcomposemultiplatformexample.data.app_info.AppInfoDataComponent
import kldemo.mvvmcomposemultiplatformexample.data.app_info.create
import kldemo.mvvmcomposemultiplatformexample.domain.app_info.AppInfoManagerComponent
import kldemo.mvvmcomposemultiplatformexample.domain.app_info.create
import kldemo.mvvmcomposemultiplatformexample.presentation.app_info.PlatformScreen
import kldemo.mvvmcomposemultiplatformexample.presentation.app_info.AppInfoViewModel
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
        composable<Screen.AppInfo> {
            PlatformScreen(viewModel {
                AppInfoViewModel(
                    AppInfoManagerComponent::class.create(
                        AppInfoDataComponent::class.create(
                            PlatformApiComponent::class.create()
                        )
                    ).appInfoManager,
                    NavigatorComponent.instance.appNavigator,
                    createSavedStateHandle()
                )
            })
        }
    }
}