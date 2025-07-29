package kldemo.mvvmcomposemultiplatformexample.presentation.app_info

import kldemo.mvvmcomposemultiplatformexample.data.app_info.AppInfo

data class AppInfoViewState(
    val numberOfClicks: Int,
    val appInfo: AppInfo?,
    val isLoading: Boolean
)
