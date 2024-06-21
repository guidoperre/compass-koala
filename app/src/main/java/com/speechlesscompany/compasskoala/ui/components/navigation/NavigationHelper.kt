package com.speechlesscompany.compasskoala.ui.components.navigation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.speechlesscompany.compasskoala.ui.components.navigation.animations.setSlideInAnimation
import com.speechlesscompany.compasskoala.ui.components.navigation.animations.setSlideOutAnimation
import com.speechlesscompany.compasskoala.ui.components.navigation.styles.statusbar.StatusBarHandler
import com.speechlesscompany.compasskoala.ui.components.navigation.styles.statusbar.StatusBarStyle

object NavigationHelper {

    fun NavGraphBuilder.composable(
        direction: NavigationCommand,
        statusBarStyle: StatusBarStyle = StatusBarStyle.Transparent,
        content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
    ) = composable(
        route = direction.destination,
        arguments = direction.arguments,
        deepLinks = direction.deepLinks,
        enterTransition = { setSlideInAnimation() },
        exitTransition = { setSlideOutAnimation() },
        popEnterTransition = { setSlideInAnimation() },
        popExitTransition = { setSlideOutAnimation() },
        content = {
            StatusBarHandler(statusBarStyle)
            content(it)
        }
    )
}
