package com.speechlesscompany.compasskoala.services.repositories.translate

import android.graphics.Bitmap
import com.speechlesscompany.compasskoala.domain.datasources.translate.TranslateDataSource
import com.speechlesscompany.compasskoala.domain.models.translate.Translate
import com.speechlesscompany.compasskoala.domain.repositories.translate.TranslateRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class NetworkTranslateRepository @Inject constructor(
    private val datasource: TranslateDataSource
) : TranslateRepository {

    override fun translateImage(image: Bitmap): Flow<Translate> {
        return datasource.translateImage(image)
    }

    override fun translateText(text: String): Flow<Translate> {
        return datasource.translateText(text)
    }
}
