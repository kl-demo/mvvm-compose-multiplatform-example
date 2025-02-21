package kldemo.mvvmcomposemultiplatformexample.presentation.start

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import kldemo.mvvmcomposemultiplatformexample.presentation.navigator.NavigatorComponent
import mvvmcomposemultiplatformexample.composeapp.generated.resources.Res
import mvvmcomposemultiplatformexample.composeapp.generated.resources.app_name
import mvvmcomposemultiplatformexample.composeapp.generated.resources.navigate_to_platform_screen
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen() {
    val startViewModel: StartViewModel =
        viewModel { StartViewModel(NavigatorComponent.instance.appNavigator) }

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(stringResource(Res.string.app_name))
            }
        )
    }) { innerPadding ->
        Content(
            startViewModel,
            innerPadding
        )
    }
}

@Composable
private fun Content(
    startViewModel: StartViewModel,
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { startViewModel.navigateToPlatformClicked() }) {
                Text(stringResource(Res.string.navigate_to_platform_screen))
            }
        }
    }
}

