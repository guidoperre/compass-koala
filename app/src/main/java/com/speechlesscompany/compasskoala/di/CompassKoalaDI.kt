package com.speechlesscompany.compasskoala.di

import com.speechlesscompany.compasskoala.domain.datasources.guide.GuideDataSource
import com.speechlesscompany.compasskoala.domain.datasources.tour.TourDataSource
import com.speechlesscompany.compasskoala.domain.datasources.translate.TranslateDataSource
import com.speechlesscompany.compasskoala.domain.datasources.trip.TripDataSource
import com.speechlesscompany.compasskoala.domain.repositories.guide.GuideRepository
import com.speechlesscompany.compasskoala.domain.repositories.tour.TourRepository
import com.speechlesscompany.compasskoala.domain.repositories.translate.TranslateRepository
import com.speechlesscompany.compasskoala.domain.repositories.trip.TripRepository
import com.speechlesscompany.compasskoala.services.datasources.guide.GeminiGuideDataSource
import com.speechlesscompany.compasskoala.services.datasources.tour.GeminiTourDataSource
import com.speechlesscompany.compasskoala.services.datasources.translate.GeminiTranslateDataSource
import com.speechlesscompany.compasskoala.services.datasources.trip.GeminiTripDataSource
import com.speechlesscompany.compasskoala.services.repositories.guide.NetworkGuideRepository
import com.speechlesscompany.compasskoala.services.repositories.tour.NetworkTourRepository
import com.speechlesscompany.compasskoala.services.repositories.translate.NetworkTranslateRepository
import com.speechlesscompany.compasskoala.services.repositories.trip.NetworkTripRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApplicationProviders {

}

@Module
@InstallIn(SingletonComponent::class)
abstract class ApplicationBinds {

    @Binds
    internal abstract fun bindGuideDataSource(
        datasource: GeminiGuideDataSource
    ): GuideDataSource

    @Binds
    internal abstract fun bindTourDataSource(
        datasource: GeminiTourDataSource
    ): TourDataSource

    @Binds
    internal abstract fun bindTranslateDataSource(
        datasource: GeminiTranslateDataSource
    ): TranslateDataSource

    @Binds
    internal abstract fun bindTripDataSource(
        datasource: GeminiTripDataSource
    ): TripDataSource

    @Binds
    internal abstract fun bindGuideRepository(
        datasource: NetworkGuideRepository
    ): GuideRepository

    @Binds
    internal abstract fun bindTourRepository(
        datasource: NetworkTourRepository
    ): TourRepository

    @Binds
    internal abstract fun bindTranslateRepository(
        datasource: NetworkTranslateRepository
    ): TranslateRepository

    @Binds
    internal abstract fun bindTripRepository(
        datasource: NetworkTripRepository
    ): TripRepository
}
