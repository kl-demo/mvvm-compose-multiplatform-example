package kldemo.mvvmcomposemultiplatformexample.presentation.navigator

import androidx.navigation.NavHostController
import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object Start : Screen()

    @Serializable
    data class AppInfo(val numberOfClicks: Int) : Screen()
}

interface AppNavigator {
    fun setController(controller: NavHostController)
    fun dispose()
    fun startScreen(): Screen
    fun navigateTo(screen: Screen)
    fun navigateBack(): Boolean
}