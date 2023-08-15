package com.rahdeva.bencanaapp.domain.model


interface DisasterTypes {
    val type: String
    val filterText: String
}
object DisasterType {
    const val FLOOD: String = "flood"
    const val EARTHQUAKE: String = "earthquake"
    const val WIND: String = "wind"
    const val HAZE: String = "haze"
    const val VOLCANO: String = "volcano"
    const val FIRE: String = "fire"
}

object DisasterFilterText {
    const val FLOOD: String = "\uD83C\uDF0A Banjir"
    const val EARTHQUAKE: String = "\uD83E\uDEE8 Gempa Bumi"
    const val WIND: String = "\uD83D\uDCA8 Badai"
    const val HAZE: String = "\uD83C\uDF2B️ Berkabut"
    const val VOLCANO: String = "\uD83C\uDF0B Gunung Meletus"
    const val FIRE: String = "\uD83D\uDD25 Kebakaran"
}