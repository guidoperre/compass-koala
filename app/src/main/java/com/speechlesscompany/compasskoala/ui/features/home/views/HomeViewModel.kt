package com.speechlesscompany.compasskoala.ui.features.home.views

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.speechlesscompany.compasskoala.extensions.string.empty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
) : ViewModel() {

    private val _generated = MutableStateFlow(String.empty())
    val generated: StateFlow<String>
        get() = _generated

    fun getImageDescription(image: Bitmap) = viewModelScope.launch {
        // TODO
    }
}
