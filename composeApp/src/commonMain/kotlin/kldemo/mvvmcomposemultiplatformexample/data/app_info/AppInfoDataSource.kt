package kldemo.mvvmcomposemultiplatformexample.data.app_info

interface AppInfoDataSource {
    suspend fun getAppInfo(): AppInfo
}