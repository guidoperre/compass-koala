package com.speechlesscompany.compasskoala.ui.components.snackbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier

@Composable
fun MainSnackbar(
    modifier: Modifier,
    manager: SnackbarManager
) {
    val snackbarHostState = rememberSnackbarHostState()

    LaunchedEffect(key1 = true) {
        manager.snackbarEvent.collect {
            snackbarHostState.showSnackbar(it)
        }
    }

    SnackbarHost(hostState = snackbarHostState, modifier = modifier)
}
