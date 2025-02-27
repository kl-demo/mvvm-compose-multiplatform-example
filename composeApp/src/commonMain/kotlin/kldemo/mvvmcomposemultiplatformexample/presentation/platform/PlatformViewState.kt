package kldemo.mvvmcomposemultiplatformexample.presentation.platform

import kldemo.mvvmcomposemultiplatformexample.data.api.Platform

data class PlatformViewState(
    val numberOfClicks: Int,
    val platform: Platform?
)
