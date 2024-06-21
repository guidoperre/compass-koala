package com.speechlesscompany.compasskoala.ui.components.snackbar

/**
 * Data class to hold [Snackbar] data.
 */
internal data class SnackbarBuilder(
    val type: SnackbarType,
    val duration: SnackbarDuration = SnackbarDuration.SHORT,
    val text: String,
    val actionOnNewLine: Boolean = false,
    val buttonText: String = "",
    val buttonClick: () -> Unit = {},
)
