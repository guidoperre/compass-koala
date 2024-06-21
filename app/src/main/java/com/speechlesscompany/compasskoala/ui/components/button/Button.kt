package com.speechlesscompany.compasskoala.ui.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.speechlesscompany.compasskoala.ui.styles.Dimen
import com.speechlesscompany.compasskoala.ui.styles.CompassKoalaTheme

@Composable
internal fun PrimaryButton(
    modifier : Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier,
        color = if (enabled) {
            CompassKoalaTheme.colors.surface
        } else {
            CompassKoalaTheme.colors.primaryVariantLight
        },
        shape = RoundedCornerShape(Dimen.ui05),
        shadowElevation = if (enabled) Dimen.ui05 else Dimen.ui0,
        border = if (!enabled) BorderStroke(
            width = Dimen.ui0125,
            color = CompassKoalaTheme.colors.primaryVariant
        ) else null,
        enabled = enabled,
        onClick = onClick
    ) {
        Box(
            modifier = Modifier
                .height(Dimen.ui6)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = if (enabled) {
                    CompassKoalaTheme.colors.primary
                } else {
                    CompassKoalaTheme.colors.secondaryVariantLight
                },
                fontWeight = FontWeight.SemiBold,
                style = CompassKoalaTheme.typography.h2,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
