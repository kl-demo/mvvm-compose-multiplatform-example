package kldemo.mvvmcomposemultiplatformexample.presentation.app_info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import composemultiplatformmvvmexample.composeapp.generated.resources.Res
import composemultiplatformmvvmexample.composeapp.generated.resources.app_info
import composemultiplatformmvvmexample.composeapp.generated.resources.error_occurred
import composemultiplatformmvvmexample.composeapp.generated.resources.hello
import composemultiplatformmvvmexample.composeapp.generated.resources.update
import kldemo.mvvmcomposemultiplatformexample.data.app_info.AppInfo
import kldemo.mvvmcomposemultiplatformexample.presentation.theme.AppTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlatformScreen(appInfoViewModel: AppInfoViewModel) {
    val appInfoViewState = appInfoViewModel.appInfoViewState.collectAsStateWithLifecycle().value

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(text = stringResource(Res.string.app_info))
            },
            navigationIcon = {
                IconButton(onClick = { appInfoViewModel.backClicked() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                }
            }
        )
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (appInfoViewState.isLoading) {
                Loading()
            } else {
                appInfoViewState.appInfo?.let { appInfo ->
                    Loaded(
                        appInfoViewState.numberOfClicks,
                        appInfo
                    )
                } ?: also {
                    Error(appInfoViewModel::updateClicked)
                }
            }
        }
    }
}

@Preview
@Composable
private fun Loading() {
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }
}

@Preview
@Composable
private fun Loaded(
    numberOfClicks: Int = 0,
    appInfo: AppInfo = AppInfo(stringResource(Res.string.app_info))
) {
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                stringResource(
                    Res.string.hello, numberOfClicks,
                    appInfo.platformName
                )
            )
        }
    }
}

@Preview
@Composable
private fun Error(
    updateClicked: () -> Unit = {}
) {
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                stringResource(
                    Res.string.error_occurred
                )
            )
            Button(
                onClick = { updateClicked() }) {
                Text(stringResource(Res.string.update))
            }
        }
    }
}

