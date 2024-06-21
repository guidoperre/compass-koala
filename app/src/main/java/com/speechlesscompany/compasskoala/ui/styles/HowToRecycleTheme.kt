package com.speechlesscompany.compasskoala.ui.styles

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import com.speechlesscompany.compasskoala.ui.styles.CompassKoalaTheme.typography

@Composable
internal fun CompassKoalaTheme(content: @Composable () -> Unit) {
    val colors = if (isSystemInDarkTheme()) { LightColors } else { DarkColors }
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }

    CompositionLocalProvider(
        LocalCompassKoalaColors provides rememberedColors,
        LocalCompassKoalaTypography provides typography,
        content = content
    )
}

internal object CompassKoalaTheme {

    /**
     * Retrieves the current [CompassKoalaColors] at the call site's position in the hierarchy.
     */
    val colors: CompassKoalaColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCompassKoalaColors.current

    /**
     * Retrieves the current [CompassKoalaTypography] at the call site's position in the hierarchy.
     */
    val typography: CompassKoalaTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalCompassKoalaTypography.current
}
