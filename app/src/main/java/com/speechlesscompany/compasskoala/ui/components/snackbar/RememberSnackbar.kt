package com.speechlesscompany.compasskoala.ui.components.snackbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
internal fun rememberSnackbarHostState(): SnackbarHostState {
    return remember { SnackbarHostState() }
}
