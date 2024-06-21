package com.speechlesscompany.compasskoala.ui.components.navigation.styles.statusbar

import androidx.compose.runtime.Composable
import com.speechlesscompany.compasskoala.ui.styles.CompassKoalaTheme
import com.speechlesscompany.compasskoala.ui.styles.FilledStatusBar
import com.speechlesscompany.compasskoala.ui.styles.TransparentStatusBar

@Composable
internal fun StatusBarHandler(style: StatusBarStyle) {
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
