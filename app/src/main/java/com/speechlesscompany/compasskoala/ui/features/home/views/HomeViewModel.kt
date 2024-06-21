package com.speechlesscompany.compasskoala.ui.features.home.views

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.speechlesscompany.compasskoala.domain.usecases.guide.GetImageDescriptionUseCase
import com.speechlesscompany.compasskoala.extensions.string.empty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getImageDescriptionUseCase: GetImageDescriptionUseCase
) : ViewModel() {

    private val _generated = MutableStateFlow(String.empty())
    val generated: StateFlow<String>
        get() = _generated

    fun getImageDescription(image: Bitmap) = viewModelScope.launch {
        _generated.emit(String.empty())
        getImageDescriptionUseCase.invoke(image)
            .catch {
                Log.i("IMAGE_CONTENT", "Error: ${it.message.orEmpty()}")
            }
            .collectLatest {
                Log.i("IMAGE_CONTENT", "Content: ${it.text.orEmpty()}")
                _generated.value += it.text.orEmpty()
            }
    }
}
