package com.speechlesscompany.compasskoala.ui.components.snackbar

import androidx.compose.material.SnackbarHost
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlin.coroutines.resume
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 *  implementation of Google Material [androidx.compose.material.SnackbarHostState]
 */
@Stable
internal class SnackbarHostState(
    currentData: SnackbarData? = null
) {

    /**
     * Only one [Snackbar] can be shown at a time.
     * Since a suspending Mutex is a fair queue, this manages our message queue
     * and we don't have to maintain one.
     */
    private val mutex = Mutex()

    /**
     * The current [SnackbarData] being shown by the [SnackbarHost], of `null` if none.
     */
    var currentSnackbarData by mutableStateOf<SnackbarData?>(currentData)
        private set

    /**
     * [SnackbarHostState] guarantees to show at most one snackbar at a time. If this function is
     * called while another snackbar is already visible, it will be suspended until this snack
     * bar is shown and subsequently addressed. If the caller is cancelled, the snackbar will be
     * removed from display and/or the queue to be displayed.
     *
     * @param snackbar data of the snackbar
     *
     * @return [SnackbarResult.ActionPerformed] if option action has been clicked or
     * [SnackbarResult.Dismissed] if snackbar has been dismissed via timeout or by the user
     */
    suspend fun showSnackbar(snackbar: SnackbarBuilder): SnackbarResult = mutex.withLock {
        try {
            return suspendCancellableCoroutine { continuation ->
                currentSnackbarData = SnackbarDataImpl(
                    snackbar.type,
                    snackbar.duration,
                    snackbar.text,
                    snackbar.actionOnNewLine,
                    snackbar.buttonText,
                    snackbar.buttonClick,
                    continuation = continuation
                )
            }
        } finally {
            currentSnackbarData = null
        }
    }

    @Stable
    internal class SnackbarDataImpl(
        override val type: SnackbarType,
        override val duration: SnackbarDuration = SnackbarDuration.SHORT,
        override val text: String,
        override val actionOnNewLine: Boolean,
        override val buttonText: String,
        override val buttonClick: () -> Unit,
        override var isDismissed: Boolean = false,
        private val continuation: CancellableContinuation<SnackbarResult>
    ) : SnackbarData {

        override fun performAction() {
            if (continuation.isActive) {
                continuation.resume(SnackbarResult.ActionPerformed)
            }
        }

        override fun dismiss() {
            if (continuation.isActive && !isDismissed) {
                isDismissed = true
                continuation.resume(SnackbarResult.Dismissed)
            }
        }
    }
}
