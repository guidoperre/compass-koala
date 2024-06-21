package com.speechlesscompany.compasskoala.ui.components.snackbar

/**
 * Interface to represent one particular [Snackbar] as a piece of the [SnackbarHostState]
 *
 * @property type type of the [Snackbar]
 * @property duration duration of the [Snackbar]
 * @property text text to be shown in the [Snackbar]
 * @property actionOnNewLine select if you want to show button text in new line in the [Snackbar]
 * @property buttonText optional action label to show as button in the [Snackbar]
 * @property buttonClick optional action to perform when action label be clicked in the [Snackbar]
 */
internal interface SnackbarData {
    val type: SnackbarType
    val duration: SnackbarDuration
    val text: String
    val actionOnNewLine: Boolean
    val buttonText: String
    val buttonClick: () -> Unit
    var isDismissed: Boolean

    /**
     * Function to be called when Snackbar action has been performed to notify the listeners
     */
    fun performAction()

    /**
     * Function to be called when Snackbar is dismissed either by timeout or by the user
     */
    fun dismiss()
}
