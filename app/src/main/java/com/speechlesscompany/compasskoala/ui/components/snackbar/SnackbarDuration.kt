package com.speechlesscompany.compasskoala.ui.components.snackbar

import java.util.Locale

internal enum class SnackbarDuration {

    /**
     * Show the Snackbar for a short period of time
     */
    SHORT,

    /**
     * Show the Snackbar for a long period of time
     */
    LONG,

    /**
     * Show the Snackbar indefinitely until explicitly dismissed or action is clicked
     */
    INDEFINITE;

    /**
     * Returns the snackbar duration expressed in millis seconds.
     */
    internal val value get() = getSnackBarDuration()

    private fun getSnackBarDuration(): Long {
        return when (this) {
            SHORT -> SHORT_DURATION
            LONG -> LONG_DURATION
            INDEFINITE -> Long.MAX_VALUE
        }
    }

    companion object {
        private const val SHORT_DURATION = 4000L
        private const val LONG_DURATION = 8000L

        fun fromString(value: String): SnackbarDuration = valueOf(value.trim().uppercase(Locale.getDefault()))
    }
}
