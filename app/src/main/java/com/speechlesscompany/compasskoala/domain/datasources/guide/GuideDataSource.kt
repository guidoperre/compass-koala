package com.speechlesscompany.compasskoala.domain.datasources.guide

import android.graphics.Bitmap
import com.speechlesscompany.compasskoala.domain.models.guide.Guide
import kotlinx.coroutines.flow.Flow

internal interface GuideDataSource {

    fun describeImage(image: Bitmap): Flow<Guide>
}
