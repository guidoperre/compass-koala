package com.speechlesscompany.compasskoala.ui.components.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink

internal abstract class NavigationCommand {

    abstract val arguments: List<NamedNavArgument>

    abstract val deepLinks: List<NavDeepLink>

    abstract val destination: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is NavigationCommand) return false

        if (destination != other.destination) return false

        return true
    }

    override fun hashCode(): Int {
        var result = arguments.hashCode()
        result = 31 * result + deepLinks.hashCode()
        result = 31 * result + destination.hashCode()
        return result
    }
}
