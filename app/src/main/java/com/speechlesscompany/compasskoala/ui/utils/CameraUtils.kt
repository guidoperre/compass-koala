package com.speechlesscompany.compasskoala.ui.utils

import android.content.Context
import android.util.Log
import android.util.Size
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.core.resolutionselector.ResolutionSelector
import androidx.camera.core.resolutionselector.ResolutionStrategy
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

internal object CameraUtils {

    @Suppress("BlockingMethodInNonBlockingContext")
    suspend fun getCameraProvider(
        context: Context
    ): ProcessCameraProvider = suspendCoroutine { continuation ->
        ProcessCameraProvider.getInstance(context).also { cameraProvider ->
            cameraProvider.addListener(
                { continuation.resume(cameraProvider.get()) },
                ContextCompat.getMainExecutor(context)
            )
        }
    }

    fun getImageCapture(): ImageCapture {
        return ImageCapture.Builder()
            .setResolutionSelector(
                ResolutionSelector.Builder()
                    .setResolutionStrategy(
                        ResolutionStrategy(
                            Size(640, 480),
                            ResolutionStrategy.FALLBACK_RULE_CLOSEST_HIGHER_THEN_LOWER
                        )
                    )
                    .build()
            )
            .build()
    }

    fun setCamera(
        owner: LifecycleOwner,
        provider: ProcessCameraProvider,
        capture: ImageCapture,
        view: PreviewView
    ) {
        val preview = Preview.Builder()
            .build()
        val selector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()
        val analyzer = ImageAnalysis.Builder()
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .setOutputImageFormat(ImageAnalysis.OUTPUT_IMAGE_FORMAT_RGBA_8888)
            .build()

        try {
            provider.bindToLifecycle(
                owner,
                selector,
                capture,
                analyzer,
                preview
            )

            preview.setSurfaceProvider(view.surfaceProvider)
        } catch (exc: Exception) {
            Log.e("IMAGE_CATCH", "Use case binding failed", exc)
        }
    }
}
