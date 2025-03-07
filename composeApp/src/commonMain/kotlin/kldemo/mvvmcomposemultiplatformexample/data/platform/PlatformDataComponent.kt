package kldemo.mvvmcomposemultiplatformexample.data.platform

import kldemo.mvvmcomposemultiplatformexample.data.api.PlatformApiComponent
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class PlatformDataComponent (@Component protected val platformApiComponent: PlatformApiComponent) {
    abstract val platformDataSource: PlatformDataSource

    @Provides
    protected fun providePlatformDataSource(platformDataSourceImpl: PlatformDataSourceImpl): PlatformDataSource = platformDataSourceImpl
}