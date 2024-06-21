package com.speechlesscompany.compasskoala.ui.styles

import android.app.Activity
import android.view.WindowManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
internal fun TransparentStatusBar() {
    val view = LocalView.current
    val window = (view.context as Activity).window

    SideEffect {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        window.statusBarColor = android.graphics.Color.TRANSPARENT
    }
}

@Composable
internal fun FilledStatusBar(
    color: Color = CompassKoalaTheme.colors.primary,
    isLight: Boolean = true
) {
    val view = LocalView.current
    val window = (view.context as Activity).window

    SideEffect {
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = isLight
        window.statusBarColor = color.toArgb()
    }
}
