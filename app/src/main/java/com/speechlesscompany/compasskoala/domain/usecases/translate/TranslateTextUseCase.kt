package com.speechlesscompany.compasskoala.domain.usecases.translate

import com.speechlesscompany.compasskoala.domain.models.translate.Translate
import com.speechlesscompany.compasskoala.domain.repositories.translate.TranslateRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class TranslateTextUseCase @Inject constructor(
    private val repository: TranslateRepository
) {

    operator fun invoke(text: String): Flow<Translate> {
        return repository.translateText(text)
    }
}
