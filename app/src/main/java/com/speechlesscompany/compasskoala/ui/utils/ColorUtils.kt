package com.speechlesscompany.compasskoala.ui.utils

import android.animation.ArgbEvaluator
import android.graphics.Color.BLACK
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils
import androidx.core.graphics.alpha
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red

object ColorUtils {

    fun String.composeColor() = Color(android.graphics.Color.parseColor(this))

    fun Color.darkColor() = with(ColorUtils.blendARGB(convertComposeColor(), BLACK, 0.2F)) {
        Color(ArgbEvaluator().evaluate(1F, this, this) as Int)
    }

    fun Color.convertComposeColor() = android.graphics.Color.argb(
        this.toArgb().alpha,
        this.toArgb().red,
        this.toArgb().green,
        this.toArgb().blue
    )
}
