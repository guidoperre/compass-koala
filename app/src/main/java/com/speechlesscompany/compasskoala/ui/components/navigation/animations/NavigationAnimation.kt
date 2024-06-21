package com.speechlesscompany.compasskoala.ui.components.navigation.animations

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally

internal fun setSlideInAnimation() = slideInHorizontally(
    initialOffsetX = { it },
    animationSpec = tween()
)

internal fun setSlideOutAnimation() = slideOutHorizontally(
    targetOffsetX = { it },
    animationSpec = tween()
)
