package com.speechlesscompany.compasskoala.domain.repositories.translate

import android.graphics.Bitmap
import com.speechlesscompany.compasskoala.domain.models.translate.Translate
import kotlinx.coroutines.flow.Flow

internal interface TranslateRepository {

    fun translateImage(image: Bitmap): Flow<Translate>

    fun translateText(text: String): Flow<Translate>
}
