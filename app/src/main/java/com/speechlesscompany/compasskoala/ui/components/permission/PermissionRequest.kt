package com.speechlesscompany.compasskoala.ui.components.permission

internal data class PermissionRequest(
    val granted: Boolean,
    val title: String,
    val description: String,
    val cta: String,
    val onClick: () -> Unit
)
