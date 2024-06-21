package com.speechlesscompany.compasskoala.ui.components.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.speechlesscompany.compasskoala.R
import com.speechlesscompany.compasskoala.ui.styles.CompassKoalaTheme
import com.speechlesscompany.compasskoala.ui.styles.Dimen

@Composable
internal fun BackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .size(Dimen.ui4)
            .clip(CircleShape)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(Dimen.ui2),
            painter = painterResource(id = R.drawable.compass_koala_back_icon),
            contentDescription = null,
            colorFilter = ColorFilter.tint(CompassKoalaTheme.colors.secondary)
        )
    }
}
