package kldemo.mvvmcomposemultiplatformexample.presentation.navigator

import androidx.navigation.NavHostController
import me.tatarka.inject.annotations.Inject

@Inject
class AppNavigatorImpl: AppNavigator {
    private var navHostController: NavHostController? = null

    override fun setController(controller: NavHostController) {
        navHostController = controller
    }

    override fun dispose() {
        navHostController = null
    }

    override fun startScreen(): Screen = Screen.Start

    override fun navigateTo(screen: Screen) {
        navHostController?.navigate(screen)
    }

    override fun back(): Boolean {
        navHostController?.run {
            return popBackStack()
        }
        return false
    }

    override fun backToStart(): Boolean {
        navHostController?.run {
            return popBackStack(
                route = startScreen(),
                inclusive = false,
                saveState = false
            )
        }
        return false
    }
}