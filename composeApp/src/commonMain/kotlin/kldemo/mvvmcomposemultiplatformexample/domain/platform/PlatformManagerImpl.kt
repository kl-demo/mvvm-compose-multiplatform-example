package kldemo.mvvmcomposemultiplatformexample.domain.platform

import kldemo.mvvmcomposemultiplatformexample.data.api.Platform
import kldemo.mvvmcomposemultiplatformexample.data.platform.PlatformDataSource
import me.tatarka.inject.annotations.Inject

@Inject
class PlatformManagerImpl(private val platformDataSource: PlatformDataSource) : PlatformManager {
    override fun getPlatform(): Platform = platformDataSource.getPlatform()
}