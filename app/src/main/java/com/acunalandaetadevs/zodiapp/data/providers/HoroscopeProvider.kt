package com.acunalandaetadevs.zodiapp.data.providers

import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo.Aquarius
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo.Aries
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo.Cancer
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo.Capricorn
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo.Gemini
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo.Leo
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo.Libra
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo.Pisces
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo.Sagittarius
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo.Scorpio
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo.Taurus
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo.Virgo
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {

    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}