package kldemo.mvvmcomposemultiplatformexample.domain.app_info

import kldemo.mvvmcomposemultiplatformexample.data.app_info.AppInfoDataComponent
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class AppInfoManagerComponent(@Component protected val appInfoDataComponent: AppInfoDataComponent) {
    abstract val appInfoManager: AppInfoManager

    @Provides
    protected fun provideAppInfoManager(appInfoManagerImpl: AppInfoManagerImpl): AppInfoManager = appInfoManagerImpl
}