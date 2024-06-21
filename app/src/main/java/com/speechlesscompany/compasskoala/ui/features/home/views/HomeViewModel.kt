package com.speechlesscompany.compasskoala.ui.features.home.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.speechlesscompany.compasskoala.ui.components.navigation.NavigationManager
import com.speechlesscompany.compasskoala.ui.navigation.directions.Directions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val navigationManager: NavigationManager
) : ViewModel() {

    fun onTripClick() = viewModelScope.launch {
        navigationManager.navigate(Directions.Trip)
    }

    fun onTourClick() = viewModelScope.launch {
        navigationManager.navigate(Directions.Tour)
    }

    fun onGuideClick() = viewModelScope.launch {
        navigationManager.navigate(Directions.Guide)
    }

    fun onTranslateClick() = viewModelScope.launch {
        navigationManager.navigate(Directions.Translate)
    }
}
