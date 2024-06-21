package com.speechlesscompany.compasskoala.ui.features.home.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.speechlesscompany.compasskoala.ui.components.button.PrimaryButton
import com.speechlesscompany.compasskoala.ui.styles.Dimen

@Composable
internal fun HomeScreen(viewModel: HomeViewModel) {
    HomeContent(
        onTripClick = viewModel::onTripClick,
        onTourClick = viewModel::onTourClick,
        onGuideClick = viewModel::onGuideClick,
        onTranslateClick = viewModel::onTranslateClick
    )
}

@Composable
internal fun HomeContent(
    onTripClick: () -> Unit,
    onTourClick: () -> Unit,
    onGuideClick: () -> Unit,
    onTranslateClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(Dimen.ui4),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimen.ui4)
    ) {
        PrimaryButton(
            text = "Trip",
            onClick = onTripClick
        )
        PrimaryButton(
            text = "Tour",
            onClick = onTourClick
        )
        PrimaryButton(
            text = "Guide",
            onClick = onGuideClick
        )
        PrimaryButton(
            text = "Translate",
            onClick = onTranslateClick
        )
    }
}
