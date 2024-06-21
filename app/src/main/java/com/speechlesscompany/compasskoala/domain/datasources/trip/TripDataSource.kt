package com.speechlesscompany.compasskoala.domain.datasources.trip

import com.speechlesscompany.compasskoala.domain.models.trip.Trip
import com.speechlesscompany.compasskoala.domain.models.trip.TripRequest
import kotlinx.coroutines.flow.Flow

internal interface TripDataSource {

    fun buildTrip(request: TripRequest): Flow<Trip>
}
