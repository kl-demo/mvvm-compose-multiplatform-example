package kldemo.mvvmcomposemultiplatformexample.domain.platform

import kldemo.mvvmcomposemultiplatformexample.data.api.Platform

interface PlatformManager {
    fun getPlatform(): Platform
}