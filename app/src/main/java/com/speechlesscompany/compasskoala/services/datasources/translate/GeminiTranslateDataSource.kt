package com.speechlesscompany.compasskoala.services.datasources.translate

import android.graphics.Bitmap
import com.speechlesscompany.compasskoala.domain.datasources.translate.TranslateDataSource
import com.speechlesscompany.compasskoala.domain.models.translate.Translate
import com.speechlesscompany.compasskoala.platform.ai.GeminiFactory
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GeminiTranslateDataSource @Inject constructor(
    private val gemini: GeminiFactory
) : TranslateDataSource {

    private val model by lazy {
        gemini.getModel()
    }

    override fun translateImage(image: Bitmap): Flow<Translate> {
        TODO("Not yet implemented")
    }

    override fun translateText(text: String): Flow<Translate> {
        TODO("Not yet implemented")
    }
}
