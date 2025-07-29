package kldemo.mvvmcomposemultiplatformexample.presentation.navigator

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object Start : Screen()

    @Serializable
    data class AppInfo(val numberOfClicks: Int) : Screen()
}