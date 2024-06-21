package com.speechlesscompany.compasskoala.ui.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager

internal object PermissionUtils {

    fun canAccessCamera(context: Context) = hasPermission(
        Manifest.permission.CAMERA,
        context
    )

    private fun hasPermission(
        permission: String,
        context: Context
    ) = PackageManager.PERMISSION_GRANTED == context.checkSelfPermission(permission)
}
