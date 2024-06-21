package com.speechlesscompany.compasskoala.domain.usecases.trip

import com.speechlesscompany.compasskoala.domain.models.trip.Trip
import com.speechlesscompany.compasskoala.domain.models.trip.TripRequest
import com.speechlesscompany.compasskoala.domain.repositories.trip.TripRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class CreateTripUseCase @Inject constructor(
    private val repository: TripRepository
) {

    operator fun invoke(request: TripRequest): Flow<Trip> {
        return repository.buildTrip(request)
    }
}
