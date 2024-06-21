package com.speechlesscompany.compasskoala.ui.components.snackbar

internal interface SnackbarListener {

    suspend fun emitSnackbar(snackbar: SnackbarBuilder)
}
