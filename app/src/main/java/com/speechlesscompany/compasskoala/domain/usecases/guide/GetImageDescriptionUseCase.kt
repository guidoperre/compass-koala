package com.speechlesscompany.compasskoala.domain.usecases.guide

import android.graphics.Bitmap
import com.speechlesscompany.compasskoala.domain.models.guide.Guide
import com.speechlesscompany.compasskoala.domain.repositories.guide.GuideRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetImageDescriptionUseCase @Inject constructor(
    private val repository: GuideRepository
) {

    operator fun invoke(image: Bitmap): Flow<Guide> {
        return repository.describeImage(image)
    }
}
