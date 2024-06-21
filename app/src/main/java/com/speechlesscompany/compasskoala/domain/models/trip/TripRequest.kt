package com.speechlesscompany.compasskoala.domain.models.trip

internal data class TripRequest(
    val destination: TripDestination,
    val budget: TripBudget,
    val dates: TripDates,
    val preferences: TripPreferences
)
