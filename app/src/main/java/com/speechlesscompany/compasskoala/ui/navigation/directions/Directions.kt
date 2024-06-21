package com.speechlesscompany.compasskoala.ui.navigation.directions

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import com.speechlesscompany.compasskoala.ui.components.navigation.NavigationCommand

object Directions {

    val Home = object : NavigationCommand() {
        override val arguments = emptyList<NamedNavArgument>()
        override val deepLinks = emptyList<NavDeepLink>()
        override val destination = "home"
    }
}
