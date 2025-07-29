package kldemo.mvvmcomposemultiplatformexample.data.app_info

import kldemo.mvvmcomposemultiplatformexample.data.api.PlatformApiComponent
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class AppInfoDataComponent (@Component protected val platformApiComponent: PlatformApiComponent) {
    abstract val appInfoDataSource: AppInfoDataSource

    @Provides
    protected fun provideAppInfoDataSource(appInfoDataSourceImpl: AppInfoDataSourceImpl): AppInfoDataSource = appInfoDataSourceImpl
}