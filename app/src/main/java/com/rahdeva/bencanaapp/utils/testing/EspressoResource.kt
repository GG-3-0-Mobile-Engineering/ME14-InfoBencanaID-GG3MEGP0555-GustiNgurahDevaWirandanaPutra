package com.rahdeva.bencanaapp.utils.testing

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoResource {
    private const val RES = "GLOBAL"
    val idlingResource = CountingIdlingResource(RES)

    fun increment() = idlingResource.increment()
    fun decrement() = idlingResource.decrement()
}