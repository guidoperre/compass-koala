package com.speechlesscompany.compasskoala.domain.usecases.tour

import com.speechlesscompany.compasskoala.domain.models.tour.Tour
import com.speechlesscompany.compasskoala.domain.models.tour.TourRequest
import com.speechlesscompany.compasskoala.domain.repositories.tour.TourRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetTourUseCase @Inject constructor(
    private val repository: TourRepository
) {

    operator fun invoke(request: TourRequest): Flow<Tour> {
        return repository.getTours(request)
    }
}
