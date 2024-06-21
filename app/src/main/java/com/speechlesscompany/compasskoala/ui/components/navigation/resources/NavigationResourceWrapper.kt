package com.speechlesscompany.compasskoala.ui.components.navigation.resources

import android.content.Context
import com.speechlesscompany.compasskoala.R
import com.speechlesscompany.compasskoala.ui.components.snackbar.SnackbarBuilder
import com.speechlesscompany.compasskoala.ui.components.snackbar.SnackbarDuration
import com.speechlesscompany.compasskoala.ui.components.snackbar.SnackbarType
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

internal class NavigationResourceWrapper @Inject constructor(
    @ApplicationContext
    private val context: Context
) {

    val getNavigationError = SnackbarBuilder(
        type = SnackbarType.ERROR,
        duration = SnackbarDuration.SHORT,
        text = context.getString(R.string.compass_koala_navigation_error)
    )
}
