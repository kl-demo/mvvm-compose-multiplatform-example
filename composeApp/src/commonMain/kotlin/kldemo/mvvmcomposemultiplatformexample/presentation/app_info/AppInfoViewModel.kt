package kldemo.mvvmcomposemultiplatformexample.presentation.app_info

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import kldemo.mvvmcomposemultiplatformexample.domain.app_info.AppInfoManager
import kldemo.mvvmcomposemultiplatformexample.presentation.navigator.AppNavigator
import kldemo.mvvmcomposemultiplatformexample.presentation.navigator.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppInfoViewModel(
    private val appInfoManager: AppInfoManager,
    private val appNavigator: AppNavigator,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val route = savedStateHandle.toRoute<Screen.AppInfo>()
    private val appInfoViewStateMutable = MutableStateFlow(
        AppInfoViewState(
            numberOfClicks = route.numberOfClicks,
            appInfo = null,
            isLoading = true
        )
    )
    val appInfoViewState = appInfoViewStateMutable.asStateFlow()

    init {
        getAppInfo()
    }

    private fun getAppInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            val appInfo = appInfoManager.getAppInfo()
            appInfoViewStateMutable.update { currentState ->
                currentState.copy(
                    appInfo = appInfo,
                    isLoading = false
                )
            }
        }
    }

    fun updateClicked() {
        appInfoViewStateMutable.update { currentState ->
            currentState.copy(
                isLoading = true
            )
        }
        getAppInfo()
    }

    fun backClicked() {
        appNavigator.back()
    }
}