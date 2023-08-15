package com.rahdeva.bencanaapp.utils

/*
 * Custom sealed class used for Network Response
 */
sealed class DataResults<out R> private constructor() {
    data class Success<out T>(val data: T) : DataResults<T>()
    data class Error<out T>(val error: String) : DataResults<T>()
}