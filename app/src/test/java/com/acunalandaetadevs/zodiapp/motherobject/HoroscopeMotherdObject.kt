package com.acunalandaetadevs.zodiapp.motherobject

import com.acunalandaetadevs.zodiapp.data.network.response.PredictionResponse
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeInfo

object HoroscopeMotherdObject {

    val anyResponse = PredictionResponse("date","prediction","tauro")

    val horoscopeInfoList = listOf(
        HoroscopeInfo.Aries,
        HoroscopeInfo.Taurus,
        HoroscopeInfo.Gemini,
        HoroscopeInfo.Cancer,
        HoroscopeInfo.Leo,
        HoroscopeInfo.Virgo,
        HoroscopeInfo.Libra,
        HoroscopeInfo.Scorpio,
        HoroscopeInfo.Sagittarius,
        HoroscopeInfo.Capricorn,
        HoroscopeInfo.Aquarius,
        HoroscopeInfo.Pisces
    )
}