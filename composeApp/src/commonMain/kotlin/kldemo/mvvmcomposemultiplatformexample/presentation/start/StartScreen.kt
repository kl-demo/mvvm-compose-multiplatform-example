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
import composemultiplatformmvvmexample.composeapp.generated.resources.Res
import composemultiplatformmvvmexample.composeapp.generated.resources.app_name
import composemultiplatformmvvmexample.composeapp.generated.resources.navigate_to_app_info_screen
import kldemo.mvvmcomposemultiplatformexample.presentation.theme.AppTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(startViewModel: StartViewModel) {

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(stringResource(Res.string.app_name))
            }
        )
    }) { innerPadding ->
        Content(
            startViewModel::navigateToAppInfoClicked,
            innerPadding
        )
    }
}

@Preview
@Composable
private fun Content(
    navigateToPlatformClicked: () -> Unit = {},
    innerPadding: PaddingValues = PaddingValues.Absolute()
) {
    AppTheme {
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
                Button(onClick = { navigateToPlatformClicked() }) {
                    Text(stringResource(Res.string.navigate_to_app_info_screen))
                }
            }
        }
    }
}

