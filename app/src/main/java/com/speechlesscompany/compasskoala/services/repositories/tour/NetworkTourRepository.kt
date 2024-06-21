package com.speechlesscompany.compasskoala.services.repositories.tour

import com.speechlesscompany.compasskoala.domain.datasources.tour.TourDataSource
import com.speechlesscompany.compasskoala.domain.models.tour.Tour
import com.speechlesscompany.compasskoala.domain.models.tour.TourRequest
import com.speechlesscompany.compasskoala.domain.repositories.tour.TourRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class NetworkTourRepository @Inject constructor(
    private val datasource: TourDataSource
) : TourRepository {

    override fun getTours(request: TourRequest): Flow<Tour> {
        return datasource.getTour(request)
    }
}
