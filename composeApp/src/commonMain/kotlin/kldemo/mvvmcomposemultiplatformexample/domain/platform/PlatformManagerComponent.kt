package kldemo.mvvmcomposemultiplatformexample.domain.platform

import kldemo.mvvmcomposemultiplatformexample.data.platform.PlatformDataComponent
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class PlatformManagerComponent(@Component protected val platformDataComponent: PlatformDataComponent) {
    abstract val platformManager: PlatformManager

    @Provides
    protected fun providePlatformManager(platformManagerImpl: PlatformManagerImpl): PlatformManager = platformManagerImpl
}