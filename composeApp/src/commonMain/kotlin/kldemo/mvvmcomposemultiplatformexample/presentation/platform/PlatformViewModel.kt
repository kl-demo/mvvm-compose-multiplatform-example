package kldemo.mvvmcomposemultiplatformexample.presentation.platform

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import kldemo.mvvmcomposemultiplatformexample.domain.platform.PlatformManager
import kldemo.mvvmcomposemultiplatformexample.presentation.navigator.AppNavigator
import kldemo.mvvmcomposemultiplatformexample.presentation.navigator.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PlatformViewModel(
    private val platformManager: PlatformManager,
    private val appNavigator: AppNavigator,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val platformViewStateMutable =
        MutableStateFlow(PlatformViewState(numberOfClicks = 0, platform = null))
    val platformViewState = platformViewStateMutable.asStateFlow()

    init {
        val route = savedStateHandle.toRoute<Screen.Platform>()
        platformViewStateMutable.update { currentState ->
            currentState.copy(
                numberOfClicks = route.numberOfClicks,
                platform = platformManager.getPlatform()
            )
        }
    }

    fun backClicked() {
        appNavigator.navigateBack()
    }
}