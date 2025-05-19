package kldemo.mvvmcomposemultiplatformexample.data.platform

import kldemo.mvvmcomposemultiplatformexample.data.api.Platform
import kldemo.mvvmcomposemultiplatformexample.data.api.PlatformApi
import me.tatarka.inject.annotations.Inject

@Inject
class PlatformDataSourceImpl(private val platformApi: PlatformApi) : PlatformDataSource {
    override fun getPlatform(): Platform = platformApi.getPlatformData()
}