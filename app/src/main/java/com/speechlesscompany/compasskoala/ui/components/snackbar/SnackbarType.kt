package com.speechlesscompany.compasskoala.ui.components.snackbar

import java.util.*

internal enum class SnackbarType {
    ERROR,
    NEUTRAL,
    SUCCESS;

    internal val value get() = getSnackbarType()

    private fun getSnackbarType(): Types.SnackbarTypeInterface {
        return when (this) {
            ERROR -> Types.SnackbarTypeError()
            NEUTRAL -> Types.SnackbarTypeNeutral()
            SUCCESS -> Types.SnackbarTypeSuccess()
        }
    }

    companion object {
        fun fromString(value: String): SnackbarType = valueOf(value.trim().uppercase(Locale.getDefault()))
    }
}
