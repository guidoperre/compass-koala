package com.speechlesscompany.compasskoala.ui.components.snackbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
internal fun SnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    val currentSnackbarData = hostState.currentSnackbarData

    LaunchedEffect(currentSnackbarData) {
        if (currentSnackbarData != null) {
            delay(currentSnackbarData.duration.value)
            currentSnackbarData.dismiss()
        }
    }

    AnimateSnackbar(
        current = hostState.currentSnackbarData,
        modifier = modifier,
        content = {
            Snackbar(hostState = hostState, snackbarData = it)
        }
    )
}
