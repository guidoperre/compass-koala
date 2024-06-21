package com.speechlesscompany.compasskoala.ui.components.permission

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.speechlesscompany.compasskoala.ui.components.button.PrimaryButton
import com.speechlesscompany.compasskoala.ui.styles.Dimen
import com.speechlesscompany.compasskoala.ui.styles.CompassKoalaTheme

@Composable
internal fun PermissionBox(onAllGranted: () -> Unit) {
    val list = getPermissionList()

    LaunchedEffect(list.all { it.granted }) {
        if (list.all { it.granted }) {
            onAllGranted.invoke()
        }
    }

    if (!list.all { it.granted }) {
        val permission = list.first { !it.granted }

        PermissionDialogContent(
            completed = list.count { it.granted },
            total = list.size,
            title = permission.title,
            description = permission.description,
            cta = permission.cta,
            onClick = permission.onClick
        )
    }
}

@Composable
internal fun PermissionDialogContent(
    completed: Int,
    total: Int,
    title: String,
    description: String,
    cta: String,
    onClick: () -> Unit
) {
    Dialog(
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        ),
        onDismissRequest = {
            // no-op
        }
    ) {
        Column(
            modifier = Modifier
                .background(
                    color = CompassKoalaTheme.colors.primary,
                    shape = RoundedCornerShape(Dimen.ui05)
                )
                .fillMaxWidth()
                .padding(Dimen.ui4),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimen.ui3)
        ) {
            PermissionStepper(
                completed = completed,
                total = total
            )
            PermissionItem(
                title = title,
                description = description
            )
            PermissionButton(
                label = cta,
                onClick = onClick
            )
        }
    }
}

@Composable
private fun PermissionStepper(
    completed: Int,
    total: Int
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(Dimen.ui2),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(completed) {
            HorizontalDivider(
                modifier = Modifier
                    .weight(1F)
                    .clip(CircleShape),
                thickness = Dimen.ui05,
                color = CompassKoalaTheme.colors.surface
            )
        }
        if (total - completed > 0) {
            repeat(total - completed) {
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1F)
                        .clip(CircleShape),
                    thickness = Dimen.ui05,
                    color = CompassKoalaTheme.colors.primaryVariantLight
                )
            }
        }
    }
}

@Composable
private fun PermissionItem(
    title: String,
    description: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimen.ui1)
    ) {
        Text(
            text = title,
            color = CompassKoalaTheme.colors.secondary,
            fontWeight = FontWeight.Medium,
            style = CompassKoalaTheme.typography.h3,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = description,
            color = CompassKoalaTheme.colors.secondary,
            fontWeight = FontWeight.Normal,
            style = CompassKoalaTheme.typography.h2,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun PermissionButton(
    label: String,
    onClick: () -> Unit
) {
    PrimaryButton(
        text = label,
        onClick = onClick
    )
}
