package com.speechlesscompany.compasskoala.ui.components.navigation.styles.statusbar

import androidx.compose.ui.graphics.Color

sealed class StatusBarStyle {
    data object Default : StatusBarStyle()
    data object Transparent : StatusBarStyle()
    internal data class Filled(val color: Color, val isLight: Boolean) : StatusBarStyle()
}
