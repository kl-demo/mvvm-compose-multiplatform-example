package kldemo.mvvmcomposemultiplatformexample.domain.app_info

import kldemo.mvvmcomposemultiplatformexample.data.app_info.AppInfo
import kldemo.mvvmcomposemultiplatformexample.data.app_info.AppInfoDataSource
import me.tatarka.inject.annotations.Inject

@Inject
class AppInfoManagerImpl(private val platformDataSource: AppInfoDataSource) : AppInfoManager {
    override suspend fun getAppInfo(): AppInfo = platformDataSource.getAppInfo()
}