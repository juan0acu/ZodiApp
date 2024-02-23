package com.acunalandaetadevs.zodiapp.data.network.response

import com.acunalandaetadevs.zodiapp.motherobject.HoroscopeMotherdObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Assert.*
import org.junit.Test

class PredictionResponseTest{
    @Test
    fun `toDomain should retunr a correct PredictionModel`(){
        //Given
        val horoscopeResponse = anyResponse

        //When
        val predictionModel = horoscopeResponse.toDomain()

        //Then
        predictionModel.sing shouldBe horoscopeResponse.sign
        predictionModel.horoscope shouldBe horoscopeResponse.horoscope
    }
}