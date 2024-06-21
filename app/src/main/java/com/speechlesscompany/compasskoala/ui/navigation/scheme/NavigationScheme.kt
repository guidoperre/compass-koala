package com.speechlesscompany.compasskoala.ui.navigation.scheme

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import com.speechlesscompany.compasskoala.ui.components.navigation.NavigationHelper.composable
import com.speechlesscompany.compasskoala.ui.features.guide.ui.GuideScreen
import com.speechlesscompany.compasskoala.ui.features.home.views.HomeScreen
import com.speechlesscompany.compasskoala.ui.features.tour.ui.TourScreen
import com.speechlesscompany.compasskoala.ui.features.translate.ui.TranslateScreen
import com.speechlesscompany.compasskoala.ui.features.trip.ui.TripScreen
import com.speechlesscompany.compasskoala.ui.navigation.directions.Directions

internal fun NavGraphBuilder.setNavigationScheme() {
    composable(direction = Directions.Home) {
        HomeScreen(viewModel = hiltViewModel())
    }
    composable(direction = Directions.Trip) {
        TripScreen(viewModel = hiltViewModel())
    }
    composable(direction = Directions.Tour) {
        TourScreen(viewModel = hiltViewModel())
    }
    composable(direction = Directions.Guide) {
        GuideScreen(viewModel = hiltViewModel())
    }
    composable(direction = Directions.Translate) {
        TranslateScreen(viewModel = hiltViewModel())
    }
}
