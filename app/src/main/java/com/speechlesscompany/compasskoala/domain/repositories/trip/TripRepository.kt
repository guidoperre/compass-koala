package com.speechlesscompany.compasskoala.domain.repositories.trip

import com.speechlesscompany.compasskoala.domain.models.trip.Trip
import com.speechlesscompany.compasskoala.domain.models.trip.TripRequest
import kotlinx.coroutines.flow.Flow

internal interface TripRepository {

    fun buildTrip(request: TripRequest): Flow<Trip>
}
