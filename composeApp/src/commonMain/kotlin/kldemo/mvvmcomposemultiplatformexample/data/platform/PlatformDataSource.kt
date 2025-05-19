package kldemo.mvvmcomposemultiplatformexample.data.platform

import kldemo.mvvmcomposemultiplatformexample.data.api.Platform

interface PlatformDataSource {
    fun getPlatform(): Platform
}