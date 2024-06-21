package com.speechlesscompany.compasskoala.domain.repositories.guide

import android.graphics.Bitmap
import com.speechlesscompany.compasskoala.domain.models.guide.Guide
import kotlinx.coroutines.flow.Flow

internal interface GuideRepository {

    fun describeImage(image: Bitmap): Flow<Guide>
}
