package kldemo.mvvmcomposemultiplatformexample.presentation.theme

import android.os.Build
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun dynamicColorScheme(isDarkTheme: Boolean): ColorScheme? {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val context = LocalContext.current
        return if (isDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }
    return null
}