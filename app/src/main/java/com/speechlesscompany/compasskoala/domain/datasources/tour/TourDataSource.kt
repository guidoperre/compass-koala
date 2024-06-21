package com.speechlesscompany.compasskoala.domain.datasources.tour

import com.speechlesscompany.compasskoala.domain.models.tour.Tour
import com.speechlesscompany.compasskoala.domain.models.tour.TourRequest
import kotlinx.coroutines.flow.Flow

internal interface TourDataSource {

    fun getTour(request: TourRequest): Flow<Tour>
}
