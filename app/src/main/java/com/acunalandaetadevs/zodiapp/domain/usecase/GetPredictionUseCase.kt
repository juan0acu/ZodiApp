package com.acunalandaetadevs.zodiapp.domain.usecase

import com.acunalandaetadevs.zodiapp.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(sing: String) = repository.getPrediction(sing)

}