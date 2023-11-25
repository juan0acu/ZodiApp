package com.acunalandaetadevs.zodiapp.domain

import com.acunalandaetadevs.zodiapp.domain.model.PredictionModel

interface Reposirory {

    suspend fun getPrediction(sing: String): PredictionModel?
}