package com.acunalandaetadevs.zodiapp.data

import android.util.Log
import com.acunalandaetadevs.zodiapp.data.network.HoroscopeApiService
import com.acunalandaetadevs.zodiapp.domain.Repository
import com.acunalandaetadevs.zodiapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImple @Inject constructor(private val apiService: HoroscopeApiService) :
    Repository {

    override suspend fun getPrediction(sing: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sing) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Error", "Ha ocurrido un error ${it.message}") }
        return null
    }
}