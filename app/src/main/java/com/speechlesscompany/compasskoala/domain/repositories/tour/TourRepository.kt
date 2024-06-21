package com.speechlesscompany.compasskoala.domain.repositories.tour

import com.speechlesscompany.compasskoala.domain.models.tour.Tour
import com.speechlesscompany.compasskoala.domain.models.tour.TourRequest
import kotlinx.coroutines.flow.Flow

internal interface TourRepository {

    fun getTours(request: TourRequest): Flow<Tour>
}
