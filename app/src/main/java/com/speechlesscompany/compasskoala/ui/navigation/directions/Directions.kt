package com.speechlesscompany.compasskoala.ui.navigation.directions

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import com.speechlesscompany.compasskoala.ui.components.navigation.NavigationCommand

internal object Directions {

    val Home = object : NavigationCommand() {
        override val arguments = emptyList<NamedNavArgument>()
        override val deepLinks = emptyList<NavDeepLink>()
        override val destination = "home"
    }

    val Trip = object : NavigationCommand() {
        override val arguments = emptyList<NamedNavArgument>()
        override val deepLinks = emptyList<NavDeepLink>()
        override val destination = "trip"
    }

    val Tour = object : NavigationCommand() {
        override val arguments = emptyList<NamedNavArgument>()
        override val deepLinks = emptyList<NavDeepLink>()
        override val destination = "tour"
    }

    val Guide = object : NavigationCommand() {
        override val arguments = emptyList<NamedNavArgument>()
        override val deepLinks = emptyList<NavDeepLink>()
        override val destination = "guide"
    }

    val Translate = object : NavigationCommand() {
        override val arguments = emptyList<NamedNavArgument>()
        override val deepLinks = emptyList<NavDeepLink>()
        override val destination = "translate"
    }
}
