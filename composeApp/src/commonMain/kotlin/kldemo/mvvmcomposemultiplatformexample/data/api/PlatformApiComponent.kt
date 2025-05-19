package kldemo.mvvmcomposemultiplatformexample.data.api

import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class PlatformApiComponent {
    abstract val platformApi: PlatformApi

    @Provides
    protected fun providePlatformApi(platformApiImpl: PlatformApiImpl): PlatformApi = platformApiImpl
}