package com.acunalandaetadevs.zodiapp.ui.detail

import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {
    data object Loading : HoroscopeDetailState()
    data class Error(val error: String) : HoroscopeDetailState()
    data class Success(val prediction: String,val sing: String, val horoscope:HoroscopeModel) : HoroscopeDetailState()
}