package com.nlgtuankiet.modularization

import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class NumberRepository @Inject constructor() {
    private val randomNumber = Random.nextInt(100, 999)

    fun getRandomNumber(): Int {
        return randomNumber
    }
}