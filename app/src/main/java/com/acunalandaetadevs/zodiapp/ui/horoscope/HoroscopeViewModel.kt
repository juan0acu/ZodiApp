package com.acunalandaetadevs.zodiapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo.Aries
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo.Gemini
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo.Taurus
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class HoroscopeViewModel @Inject constructor() : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        _horoscope.value = listOf(
            Aries, Taurus, Gemini
        )
    }
}