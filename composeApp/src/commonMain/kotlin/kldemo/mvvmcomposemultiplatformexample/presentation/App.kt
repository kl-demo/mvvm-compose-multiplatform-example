package kldemo.mvvmcomposemultiplatformexample.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import kldemo.mvvmcomposemultiplatformexample.presentation.navigator.AppNavHost
import kldemo.mvvmcomposemultiplatformexample.presentation.navigator.AppNavigator
import kldemo.mvvmcomposemultiplatformexample.presentation.navigator.NavigatorComponent
import kldemo.mvvmcomposemultiplatformexample.presentation.theme.AppTheme

@Preview
@Composable
fun App() {
    val appNavigator = NavigatorComponent.instance.appNavigator
    viewModel { AppViewModel(appNavigator) }

    AppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            val navController: NavHostController = rememberNavController()
            appNavigator.setController(navController)
            AppNavHost(
                navController,
                appNavigator.startScreen()
            )
        }
    }
}

class AppViewModel(private val appNavigator: AppNavigator) : ViewModel() {
    override fun onCleared() {
        super.onCleared()
        appNavigator.dispose()
    }
}