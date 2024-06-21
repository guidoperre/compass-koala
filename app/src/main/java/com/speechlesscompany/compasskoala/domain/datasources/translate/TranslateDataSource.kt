package com.speechlesscompany.compasskoala.domain.datasources.translate

import android.graphics.Bitmap
import com.speechlesscompany.compasskoala.domain.models.translate.Translate
import kotlinx.coroutines.flow.Flow

internal interface TranslateDataSource {

    fun translateImage(image: Bitmap): Flow<Translate>

    fun translateText(text: String): Flow<Translate>
}
