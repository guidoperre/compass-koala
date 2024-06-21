package com.speechlesscompany.compasskoala.platform.ai

import com.google.firebase.Firebase
import com.google.firebase.vertexai.GenerativeModel
import com.google.firebase.vertexai.type.BlockThreshold
import com.google.firebase.vertexai.type.Content
import com.google.firebase.vertexai.type.GenerationConfig
import com.google.firebase.vertexai.type.HarmCategory
import com.google.firebase.vertexai.type.SafetySetting
import com.google.firebase.vertexai.vertexAI
import javax.inject.Inject

internal class GeminiManager @Inject constructor() {

    private lateinit var model: GenerativeModel

    fun getModel(instruction: Content? = null): GenerativeModel {
        if (!::model.isInitialized) {
            model = Firebase.vertexAI.generativeModel(
                modelName = GEMINI_VERSION,
                generationConfig = getGenerationConfig(),
                safetySettings = getSafetySettings(),
                systemInstruction = instruction
            )
        }

        return model
    }

    private fun getGenerationConfig(): GenerationConfig {
        return GenerationConfig.Builder().apply {

        }.build()
    }

    private fun getSafetySettings(): List<SafetySetting> {
        return listOf(
            SafetySetting(
                harmCategory = HarmCategory.SEXUALLY_EXPLICIT,
                threshold = BlockThreshold.ONLY_HIGH
            ),
            SafetySetting(
                harmCategory = HarmCategory.DANGEROUS_CONTENT,
                threshold = BlockThreshold.ONLY_HIGH
            ),
            SafetySetting(
                harmCategory = HarmCategory.HATE_SPEECH,
                threshold = BlockThreshold.ONLY_HIGH
            ),
            SafetySetting(
                harmCategory = HarmCategory.HARASSMENT,
                threshold = BlockThreshold.ONLY_HIGH
            )
        )
    }

    companion object {
        private const val GEMINI_VERSION = "gemini-1.5-pro"
    }
}
