package com.speechlesscompany.compasskoala.services.datasources.tour

import com.speechlesscompany.compasskoala.domain.datasources.tour.TourDataSource
import com.speechlesscompany.compasskoala.domain.models.tour.Tour
import com.speechlesscompany.compasskoala.domain.models.tour.TourRequest
import com.speechlesscompany.compasskoala.platform.ai.GeminiFactory
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GeminiTourDataSource @Inject constructor(
    private val gemini: GeminiFactory
) : TourDataSource {

    private val model by lazy {
        gemini.getModel()
    }

    override fun getTour(request: TourRequest): Flow<Tour> {
        TODO("Not yet implemented")
    }
}
