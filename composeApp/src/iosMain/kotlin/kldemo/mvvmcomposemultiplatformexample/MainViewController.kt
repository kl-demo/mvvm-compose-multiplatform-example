package kldemo.mvvmcomposemultiplatformexample

import androidx.compose.ui.window.ComposeUIViewController
import kldemo.mvvmcomposemultiplatformexample.presentation.App

fun MainViewController() = ComposeUIViewController { App() }