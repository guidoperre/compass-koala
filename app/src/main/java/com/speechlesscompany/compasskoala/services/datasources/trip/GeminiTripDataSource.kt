package com.speechlesscompany.compasskoala.services.datasources.trip

import com.speechlesscompany.compasskoala.domain.datasources.trip.TripDataSource
import com.speechlesscompany.compasskoala.domain.models.trip.Trip
import com.speechlesscompany.compasskoala.domain.models.trip.TripRequest
import com.speechlesscompany.compasskoala.platform.ai.GeminiFactory
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GeminiTripDataSource @Inject constructor(
    private val gemini: GeminiFactory
) : TripDataSource {

    private val model by lazy {
        gemini.getModel()
    }

    override fun buildTrip(request: TripRequest): Flow<Trip> {
        TODO("Not yet implemented")
    }
}
