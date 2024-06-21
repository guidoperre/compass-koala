package com.speechlesscompany.compasskoala.ui.components.divider

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.speechlesscompany.compasskoala.ui.styles.CompassKoalaTheme
import com.speechlesscompany.compasskoala.ui.styles.Dimen

@Composable
internal fun ListDivider() {
    HorizontalDivider(
        modifier = Modifier
            .padding(horizontal = Dimen.ui4)
            .fillMaxWidth(),
        color = CompassKoalaTheme.colors.primaryVariantLight
    )
}
