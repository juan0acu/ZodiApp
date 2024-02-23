package com.acunalandaetadevs.zodiapp.ui.providers

import org.junit.Assert.*
import org.junit.Test

class RandomCardProviderTest{

    @Test
    fun `getRandomCard should return a random card`(){
        //Given
        val randomCardProvider = RandomCardProvider()

        //When
        val card = randomCardProvider.getLucky()

        //Then
        assertNotNull(card)
    }
}