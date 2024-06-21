package com.speechlesscompany.compasskoala.ui.components.snackbar

import androidx.compose.runtime.Composable

internal typealias AnimationTransition = @Composable (content: @Composable () -> Unit) -> Unit
