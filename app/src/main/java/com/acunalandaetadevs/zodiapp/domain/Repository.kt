package com.acunalandaetadevs.zodiapp.domain

import com.acunalandaetadevs.zodiapp.domain.model.PredictionModel

interface Repository {

    suspend fun getPrediction(sing: String): PredictionModel?
}