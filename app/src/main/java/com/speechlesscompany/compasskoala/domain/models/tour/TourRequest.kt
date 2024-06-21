package com.speechlesscompany.compasskoala.domain.models.tour

import com.speechlesscompany.compasskoala.domain.models.tour.preferences.TourActivity
import com.speechlesscompany.compasskoala.domain.models.tour.preferences.TourPrice
import java.util.Date

internal data class TourRequest(
    val date: Date,
    val activity: TourActivity,
    val price: TourPrice
)
