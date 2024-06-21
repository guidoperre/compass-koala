package com.speechlesscompany.compasskoala.ui.components.navigation.deeplink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.core.util.Consumer
import androidx.navigation.NavHostController

@Composable
fun DeeplinkHandler(
    activity: AppCompatActivity,
    controller: NavHostController
) {
    DisposableEffect(controller) {
        val consumer = Consumer<Intent> { controller.handleDeepLink(it) }

        activity.addOnNewIntentListener(consumer)

        onDispose {
            activity.removeOnNewIntentListener(consumer)
        }
    }
}
