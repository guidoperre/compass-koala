package com.speechlesscompany.compasskoala.domain.usecases.translate

import android.graphics.Bitmap
import com.speechlesscompany.compasskoala.domain.models.translate.Translate
import com.speechlesscompany.compasskoala.domain.repositories.translate.TranslateRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class TranslateImageUseCase @Inject constructor(
    private val repository: TranslateRepository
) {

    operator fun invoke(image: Bitmap): Flow<Translate> {
        return repository.translateImage(image)
    }
}
