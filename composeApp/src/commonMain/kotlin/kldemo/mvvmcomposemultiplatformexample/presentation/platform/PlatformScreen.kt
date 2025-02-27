package kldemo.mvvmcomposemultiplatformexample.presentation.platform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import kldemo.mvvmcomposemultiplatformexample.data.api.PlatformApiComponent
import kldemo.mvvmcomposemultiplatformexample.data.api.create
import kldemo.mvvmcomposemultiplatformexample.data.platform.PlatformDataComponent
import kldemo.mvvmcomposemultiplatformexample.data.platform.create
import kldemo.mvvmcomposemultiplatformexample.domain.platform.PlatformManagerComponent
import kldemo.mvvmcomposemultiplatformexample.domain.platform.create
import kldemo.mvvmcomposemultiplatformexample.presentation.navigator.NavigatorComponent
import mvvmcomposemultiplatformexample.composeapp.generated.resources.Res
import mvvmcomposemultiplatformexample.composeapp.generated.resources.hello
import mvvmcomposemultiplatformexample.composeapp.generated.resources.platform
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlatformScreen() {
    val platformViewModel: PlatformViewModel = viewModel {
        PlatformViewModel(
            PlatformManagerComponent::class.create(
                PlatformDataComponent::class.create(
                    PlatformApiComponent::class.create()
                )
            ).platformManager,
            NavigatorComponent.instance.appNavigator,
            createSavedStateHandle()
        )
    }
    val platformViewState = platformViewModel.platformViewState.collectAsStateWithLifecycle().value

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(text = stringResource(Res.string.platform))
            },
            navigationIcon = {
                IconButton(onClick = { platformViewModel.backClicked() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                }
            }
        )
    }) { innerPadding ->
        Content(
            platformViewState,
            innerPadding
        )
    }
}

@Preview
@Composable
private fun Content(
    platformViewState: PlatformViewState = PlatformViewState(0, null),
    innerPadding: PaddingValues = PaddingValues.Absolute()
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
            Text(
                stringResource(
                    Res.string.hello, platformViewState.numberOfClicks,
                    platformViewState.platform?.name ?: ""
                )
            )
        }
    }
}

