package com.speechlesscompany.compasskoala.services.datasources.guide

import android.graphics.Bitmap
import com.speechlesscompany.compasskoala.domain.datasources.guide.GuideDataSource
import com.speechlesscompany.compasskoala.domain.models.guide.Guide
import com.speechlesscompany.compasskoala.platform.ai.GeminiFactory
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GeminiGuideDataSource @Inject constructor(
    private val gemini: GeminiFactory
) : GuideDataSource {

    private val model by lazy {
        gemini.getModel()
    }

    override fun describeImage(image: Bitmap): Flow<Guide> {
        TODO("Not yet implemented")
    }
}
