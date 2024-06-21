package com.speechlesscompany.compasskoala.ui.components.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Snackbar
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.speechlesscompany.compasskoala.ui.styles.Dimen
import com.speechlesscompany.compasskoala.ui.styles.CompassKoalaTheme

/**
 * compasskoala implementation of Google Material Snackbar.
 *
 * @param snackbarData an implementation of [SnackbarData]
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Snackbar(
    hostState: SnackbarHostState,
    snackbarData: SnackbarData
) {
    val dismissState = rememberDismissState(
        confirmStateChange = {
            if (it != DismissValue.Default) {
                hostState.currentSnackbarData?.dismiss()
            }
            true
        }
    )

    SwipeToDismiss(
        state = dismissState,
        background = {},
        dismissThresholds = { FractionalThreshold(0.9f) }
    ) {
        Snackbar(
            backgroundColor = snackbarData.type.value.getBackgroundColor(),
            actionOnNewLine = snackbarData.actionOnNewLine,
            action = {
                if (snackbarData.buttonText.isNotBlank()) {
                    Box(
                        Modifier
                            .padding(bottom = Dimen.ui1_5, end = Dimen.ui2)
                            .clip(RoundedCornerShape(Dimen.ui05))
                            .background(snackbarData.type.value.getButtonColor())
                            .clickable(onClick = snackbarData.buttonClick)
                    ) {
                        Text(
                            text = snackbarData.buttonText,
                            fontWeight = FontWeight.Bold,
                            color = snackbarData.type.value.getTextColor(),
                            style = CompassKoalaTheme.typography.h1,
                            modifier = Modifier.padding(
                                start = Dimen.ui1,
                                top = Dimen.ui05,
                                end = Dimen.ui1,
                                bottom = Dimen.ui05 + Dimen.ui006125
                            )
                        )
                    }
                }
            },
            content = {
                Text(
                    text = snackbarData.text,
                    fontWeight = FontWeight.SemiBold,
                    color = snackbarData.type.value.getTextColor(),
                    style = CompassKoalaTheme.typography.h2.copy(
                        lineHeight = 22.sp
                    ),
                    modifier = Modifier.padding(vertical = Dimen.ui1_5)
                )
            }
        )
    }
}
