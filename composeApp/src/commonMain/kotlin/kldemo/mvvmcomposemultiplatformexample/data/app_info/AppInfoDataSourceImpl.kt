package kldemo.mvvmcomposemultiplatformexample.data.app_info

import kldemo.mvvmcomposemultiplatformexample.data.api.PlatformApi
import kotlinx.coroutines.delay
import me.tatarka.inject.annotations.Inject

@Inject
class AppInfoDataSourceImpl(private val platformApi: PlatformApi) : AppInfoDataSource {
    override suspend fun getAppInfo(): AppInfo {
        delay(1000)//emulate network latency
        return AppInfo(platformApi.getPlatformData().name)
    }
}