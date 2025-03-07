package kldemo.mvvmcomposemultiplatformexample.data.api

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform