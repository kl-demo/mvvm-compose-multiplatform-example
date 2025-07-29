package kldemo.mvvmcomposemultiplatformexample.domain.app_info

import kldemo.mvvmcomposemultiplatformexample.data.app_info.AppInfo

interface AppInfoManager {
    suspend fun getAppInfo(): AppInfo
}