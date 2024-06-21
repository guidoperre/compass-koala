@file:Suppress("DEPRECATION")

package com.speechlesscompany.compasskoala.ui.components.shimmer

import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.speechlesscompany.compasskoala.ui.styles.CompassKoalaTheme

fun Modifier.shimmer(shape: Shape = RectangleShape): Modifier = composed {
    this.then(
        placeholder(
            visible = true,
            color = CompassKoalaTheme.colors.primaryVariantLight,
            shape = shape,
            highlight = PlaceholderHighlight.shimmer(
                highlightColor = Color.White
            )
        )
    )
}
