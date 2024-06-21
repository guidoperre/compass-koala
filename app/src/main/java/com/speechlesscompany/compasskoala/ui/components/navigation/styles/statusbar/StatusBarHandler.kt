package com.speechlesscompany.compasskoala.ui.components.navigation.styles.statusbar

import androidx.compose.runtime.Composable
import com.speechlesscompany.compasskoala.ui.styles.FilledStatusBar
import com.speechlesscompany.compasskoala.ui.styles.TransparentStatusBar
import com.speechlesscompany.compasskoala.ui.styles.CompassKoalaTheme

@Composable
fun StatusBarHandler(style: StatusBarStyle) {
    when(style) {
        is StatusBarStyle.Transparent -> TransparentStatusBar()
        is StatusBarStyle.Default -> FilledStatusBar(
            color = CompassKoalaTheme.colors.primary,
            isLight = true
        )
        is StatusBarStyle.Filled -> FilledStatusBar(
            color = style.color,
            isLight = style.isLight
        )
    }
}
