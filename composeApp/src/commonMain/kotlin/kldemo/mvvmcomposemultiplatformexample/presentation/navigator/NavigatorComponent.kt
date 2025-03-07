package kldemo.mvvmcomposemultiplatformexample.presentation.navigator

import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import me.tatarka.inject.annotations.Scope

@Scope
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER
)
annotation class AppNavigatorScope

@AppNavigatorScope
@Component
abstract class NavigatorComponent {
    abstract val appNavigator: AppNavigator

    @AppNavigatorScope
    @Provides
    protected fun provideAppNavigator(appNavigatorImpl: AppNavigatorImpl): AppNavigator = appNavigatorImpl

    companion object{
        val instance = NavigatorComponent::class.create()
    }
}

