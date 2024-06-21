package com.speechlesscompany.compasskoala.services.repositories.trip

import com.speechlesscompany.compasskoala.domain.datasources.trip.TripDataSource
import com.speechlesscompany.compasskoala.domain.models.trip.Trip
import com.speechlesscompany.compasskoala.domain.models.trip.TripRequest
import com.speechlesscompany.compasskoala.domain.repositories.trip.TripRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class NetworkTripRepository @Inject constructor(
    private val datasource: TripDataSource
) : TripRepository {

    override fun buildTrip(request: TripRequest): Flow<Trip> {
        return datasource.buildTrip(request)
    }
}
