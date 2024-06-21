package com.speechlesscompany.compasskoala.ui.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.WindowManager
import kotlin.math.roundToInt

object ScreenUtils {

    @Suppress("DEPRECATION")
    fun getWidth(manager: WindowManager): Int {
        val displayMetrics = DisplayMetrics()
        manager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }

    val Number.toPx get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )

    val Number.toDp get() = run {
        val density = Resources.getSystem().displayMetrics.densityDpi.toFloat()
        (this.toFloat() / (density / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
    }
}
