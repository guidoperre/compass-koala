package com.speechlesscompany.compasskoala.ui.components.snackbar

/**
 * Possible results of the [SnackbarHostState.showSnackbar] call
 */
internal enum class SnackbarResult {
    /**
     * [Snackbar] that is shown has been dismissed either by timeout of by user
     */
    Dismissed,

    /**
     * Action on the [Snackbar] has been clicked before the time out passed
     */
    ActionPerformed,
}
