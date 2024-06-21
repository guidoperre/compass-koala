package com.speechlesscompany.compasskoala.ui.components.navigation

import android.util.Log
import androidx.navigation.NavHostController
import com.speechlesscompany.compasskoala.ui.components.navigation.resources.NavigationResourceWrapper
import com.speechlesscompany.compasskoala.ui.components.snackbar.SnackbarManager
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Singleton
internal class NavigationManager @Inject constructor(
    private val snackbarManager: SnackbarManager,
    private val resourceWrapper: NavigationResourceWrapper
) {

    private lateinit var controller: NavHostController

    fun setHostController(controller: NavHostController) {
        this.controller = controller
    }

    fun getCurrentRoute() = controller.currentDestination?.route

    suspend fun back() {
        try {
            withContext(Dispatchers.Main) {
                controller.popBackStack()
            }
        } catch (e: IllegalArgumentException) {
            snackbarManager.showSnackbar(resourceWrapper.getNavigationError)
        } catch (e: Exception) {
            Log.e(TAG, NAVIGATION_ERROR + e.message.toString())
        }
    }

    suspend fun popUpBack(command: NavigationCommand) {
        try {
            withContext(Dispatchers.Main) {
                controller.popBackStack(
                    route = command.destination,
                    inclusive = true
                )
            }
        } catch (e: IllegalArgumentException) {
            snackbarManager.showSnackbar(resourceWrapper.getNavigationError)
        } catch (e: Exception) {
            Log.e(TAG, NAVIGATION_ERROR + e.message.toString())
        }
    }

    suspend fun navigate(command: NavigationCommand) {
        try {
            withContext(Dispatchers.Main) {
                controller.navigate(command.destination)
            }
        } catch (e: IllegalArgumentException) {
            snackbarManager.showSnackbar(resourceWrapper.getNavigationError)
        } catch (e: Exception) {
            Log.e(TAG, NAVIGATION_ERROR + e.message.toString())
        }
    }

    suspend fun popupNavigate(
        command: NavigationCommand,
        until: NavigationCommand,
        inclusive: Boolean = true
    ) {
        try {
            withContext(Dispatchers.Main) {
                controller.navigate(command.destination) {
                    popUpTo(until.destination) {
                        this.inclusive = inclusive
                    }
                }
            }
        } catch (e: IllegalArgumentException) {
            snackbarManager.showSnackbar(resourceWrapper.getNavigationError)
        } catch (e: Exception) {
            Log.e(TAG, NAVIGATION_ERROR + e.message.toString())
        }
    }

    companion object {
        private const val TAG = "NAVIGATION_MANAGER"

        private const val NAVIGATION_ERROR = "Navigation not executed: "
    }
}
