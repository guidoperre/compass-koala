package com.speechlesscompany.compasskoala.ui.navigation.scheme

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import com.speechlesscompany.compasskoala.ui.components.navigation.NavigationHelper.composable
import com.speechlesscompany.compasskoala.ui.features.home.views.HomeScreen
import com.speechlesscompany.compasskoala.ui.navigation.directions.Directions

internal fun NavGraphBuilder.setNavigationScheme() {
    composable(direction = Directions.Home) {
        HomeScreen(viewModel = hiltViewModel())
    }
}
