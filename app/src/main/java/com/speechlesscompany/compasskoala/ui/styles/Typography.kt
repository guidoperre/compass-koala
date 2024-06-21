package com.speechlesscompany.compasskoala.ui.styles

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

@Immutable
internal class CompassKoalaTypography internal constructor(
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val h5: TextStyle,
    val h6: TextStyle,
    val h7: TextStyle,
    val h8: TextStyle,
) {
    constructor(
        defaultFontFamily: FontFamily = Font.QuickSand,
        h1: TextStyle = TextStyle(fontSize = 12.sp),
        h2: TextStyle = TextStyle(fontSize = 14.sp),
        h3: TextStyle = TextStyle(fontSize = 16.sp),
        h4: TextStyle = TextStyle(fontSize = 18.sp),
        h5: TextStyle = TextStyle(fontSize = 20.sp),
        h6: TextStyle = TextStyle(fontSize = 22.sp),
        h7: TextStyle = TextStyle(fontSize = 24.sp),
        h8: TextStyle = TextStyle(fontSize = 26.sp),
    ) : this(
        h1 = h1.withDefaultFontFamily(defaultFontFamily),
        h2 = h2.withDefaultFontFamily(defaultFontFamily),
        h3 = h3.withDefaultFontFamily(defaultFontFamily),
        h4 = h4.withDefaultFontFamily(defaultFontFamily),
        h5 = h5.withDefaultFontFamily(defaultFontFamily),
        h6 = h6.withDefaultFontFamily(defaultFontFamily),
        h7 = h7.withDefaultFontFamily(defaultFontFamily),
        h8 = h8.withDefaultFontFamily(defaultFontFamily),
    )

    override fun toString(): String {
        return "Typography(h1=$h1, h2=$h2, h3=$h3, h4=$h4, h5=$h5, h6=$h6, h7=$h7, h8=$h8"
    }
}

/**
 * @return [this] if there is a [Font] defined, otherwise copies [this] with [default] as
 * the [Font].
 */
private fun TextStyle.withDefaultFontFamily(default: FontFamily): TextStyle {
    return copy(fontFamily = default, letterSpacing = 0.sp)
}

/**
 * This CompositionLocal holds on to the current definition of typography for this application as
 * described by the Material spec. You can read the values in it when creating custom components
 * that want to use Material types, as well as override the values when you want to re-style a
 * part of your hierarchy. Material components related to text such as [Button] will use this
 * CompositionLocal to set values with which to style children text components.
 *
 * To access values within this CompositionLocal, use [CompassKoalaTheme.typography].
 */
internal val LocalCompassKoalaTypography = staticCompositionLocalOf { CompassKoalaTypography() }
