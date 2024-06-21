package com.speechlesscompany.compasskoala.ui.styles

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color

@Stable
internal class CompassKoalaColors(
    primary: Color,
    primaryVariant: Color,
    primaryVariantLight: Color,
    secondary: Color,
    secondaryVariant: Color,
    secondaryVariantLight: Color,
    surface: Color,
    surfaceVariant: Color,
    background: Color,
    error: Color,
    success: Color,
    isLight: Boolean
) {
    var primary by mutableStateOf(primary, structuralEqualityPolicy())
        internal set
    var primaryVariant by mutableStateOf(primaryVariant, structuralEqualityPolicy())
        internal set
    var primaryVariantLight by mutableStateOf(primaryVariantLight, structuralEqualityPolicy())
        internal set
    var secondary by mutableStateOf(secondary, structuralEqualityPolicy())
        internal set
    var secondaryVariant by mutableStateOf(secondaryVariant, structuralEqualityPolicy())
        internal set
    var secondaryVariantLight by mutableStateOf(secondaryVariantLight, structuralEqualityPolicy())
        internal set
    var surface by mutableStateOf(surface, structuralEqualityPolicy())
        internal set
    var surfaceVariant by mutableStateOf(surfaceVariant, structuralEqualityPolicy())
        internal set
    var background by mutableStateOf(background, structuralEqualityPolicy())
        internal set
    var error by mutableStateOf(error, structuralEqualityPolicy())
        internal set
    var success by mutableStateOf(success, structuralEqualityPolicy())
        internal set
    var isLight by mutableStateOf(isLight, structuralEqualityPolicy())
        internal set

    /**
     * Returns a copy of this Colors, optionally overriding some of the values.
     */
    fun copy(
        primary: Color = this.primary,
        primaryVariant: Color = this.primaryVariant,
        primaryVariantLight: Color = this.primaryVariantLight,
        secondary: Color = this.secondary,
        secondaryVariant: Color = this.secondaryVariant,
        secondaryVariantLight: Color = this.secondaryVariantLight,
        surface: Color = this.surface,
        surfaceVariant: Color = this.surfaceVariant,
        background: Color = this.background,
        error: Color = this.error,
        success: Color = this.success,
        isLight: Boolean = this.isLight
    ): CompassKoalaColors = CompassKoalaColors(
        primary,
        primaryVariant,
        primaryVariantLight,
        secondary,
        secondaryVariant,
        secondaryVariantLight,
        surface,
        surfaceVariant,
        background,
        error,
        success,
        isLight
    )

    override fun toString(): String {
        return "Colors(" +
                "primary=$primary, " +
                "primaryVariant=$primaryVariant, " +
                "primaryVariantLight=$primaryVariantLight, " +
                "secondary=$secondary, " +
                "secondaryVariant=$secondaryVariant, " +
                "secondaryVariantLight=$secondaryVariantLight, " +
                "surface=$surface, " +
                "surfaceVariant=$surfaceVariant, " +
                "background=$background, " +
                "error=$error, " +
                "success=$success, " +
                "isLight=$isLight" +
                ")"
    }
}

val LightColors = CompassKoalaColors(
    primary = Color.White,
    primaryVariant = Color(0XFF6F6F6F),
    primaryVariantLight = Color(0XFFDCDCDC),
    secondary = Color(0XFF333333),
    secondaryVariant = Color.Black,
    secondaryVariantLight = Color(0XFF777777),
    surface =  Color(0xFF842AE6),
    surfaceVariant = Color(0XFF7719DE),
    background = Color.White,
    error = Color(0XFFC73F3A),
    success = Color(0XFF1A824C),
    isLight = true
)

val DarkColors = CompassKoalaColors(
    primary = Color.White,
    primaryVariant = Color(0XFF6F6F6F),
    primaryVariantLight = Color(0XFFDCDCDC),
    secondary = Color(0XFF333333),
    secondaryVariant = Color.Black,
    secondaryVariantLight = Color(0XFF777777),
    surface =  Color(0xFF842AE6),
    surfaceVariant = Color(0XFF7719DE),
    background = Color.White,
    error = Color(0XFFC73F3A),
    success = Color(0XFF1A824C),
    isLight = true
)

val LocalCompassKoalaColors = staticCompositionLocalOf { LightColors }

/**
 * Updates the internal values of the given [CompassKoalaColors] with values from the [other] [CompassKoalaColors]. This
 * allows efficiently updating a subset of [CompassKoalaColors], without recomposing every composable that
 * consumes values from [LocalCompassKoalaColors].
 *
 * Because [CompassKoalaColors] is very wide-reaching, and used by many expensive composables in the
 * hierarchy, providing a new value to [LocalCompassKoalaColors] causes every composable consuming
 * [LocalCompassKoalaColors] to recompose, which is prohibitively expensive in cases such as animating one
 * color in the theme. Instead, [CompassKoalaColors] is internally backed by [mutableStateOf], and this
 * function mutates the internal state of [this] to match values in [other]. This means that any
 * changes will mutate the internal state of [this], and only cause composables that are reading
 * the specific changed value to recompose.
 */
internal fun CompassKoalaColors.updateColorsFrom(other: CompassKoalaColors) {
    primary = other.primary
    primaryVariant = other.primaryVariant
    primaryVariantLight = other.primaryVariantLight
    secondary = other.secondary
    secondaryVariant = other.secondaryVariant
    secondaryVariantLight = other.secondaryVariantLight
    surface = other.surface
    surfaceVariant = other.surfaceVariant
    background = other.background
    error = other.error
    success = other.success
    isLight = true
}
