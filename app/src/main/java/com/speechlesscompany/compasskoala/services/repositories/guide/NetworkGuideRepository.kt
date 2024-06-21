package com.speechlesscompany.compasskoala.services.repositories.guide

import android.graphics.Bitmap
import com.speechlesscompany.compasskoala.domain.datasources.guide.GuideDataSource
import com.speechlesscompany.compasskoala.domain.models.guide.Guide
import com.speechlesscompany.compasskoala.domain.repositories.guide.GuideRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class NetworkGuideRepository @Inject constructor(
    private val datasource: GuideDataSource
) : GuideRepository {

    override fun describeImage(image: Bitmap): Flow<Guide> {
        return datasource.describeImage(image)
    }
}
