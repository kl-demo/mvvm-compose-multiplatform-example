package kldemo.mvvmcomposemultiplatformexample.data.api

import me.tatarka.inject.annotations.Inject

@Inject
class PlatformApiImpl: PlatformApi {
    override fun getPlatformData(): Platform = getPlatform()
}