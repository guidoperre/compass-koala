package com.speechlesscompany.compasskoala.domain.models.trip

import com.speechlesscompany.compasskoala.domain.models.trip.preferences.TripActivity
import com.speechlesscompany.compasskoala.domain.models.trip.preferences.TripDensity

internal data class TripPreferences(
    val density: TripDensity,
    val activity: TripActivity
)
