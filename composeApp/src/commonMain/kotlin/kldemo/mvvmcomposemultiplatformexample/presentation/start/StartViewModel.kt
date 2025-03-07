package kldemo.mvvmcomposemultiplatformexample.presentation.start

import androidx.lifecycle.ViewModel
import kldemo.mvvmcomposemultiplatformexample.presentation.navigator.AppNavigator
import kldemo.mvvmcomposemultiplatformexample.presentation.navigator.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class StartViewModel(private val appNavigator: AppNavigator) : ViewModel() {
    private val startViewStateMutable = MutableStateFlow(StartViewState(numberOfClicks = 0))
    val startViewState = startViewStateMutable.asStateFlow()

    fun navigateToPlatformClicked() {
        startViewStateMutable.update { currentState ->
            currentState.copy(numberOfClicks = currentState.numberOfClicks + 1)
        }
        appNavigator.navigateTo(Screen.Platform(startViewState.value.numberOfClicks))
    }
}