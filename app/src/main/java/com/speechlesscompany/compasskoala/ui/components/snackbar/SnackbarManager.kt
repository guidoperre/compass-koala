package com.speechlesscompany.compasskoala.ui.components.snackbar

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class SnackbarManager @Inject constructor() {

    private val _snackbarEvent = MutableSharedFlow<SnackbarBuilder>()
    internal val snackbarEvent: SharedFlow<SnackbarBuilder>
        get() = _snackbarEvent

    suspend fun showSnackbar(snackbar: SnackbarBuilder) {
        _snackbarEvent.emit(snackbar)
    }
}
