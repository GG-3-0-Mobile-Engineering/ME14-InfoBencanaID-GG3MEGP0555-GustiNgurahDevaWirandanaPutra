package com.rahdeva.bencanaapp.domain.model

/*
 *  Enum class for Disaster Type Filter.
 *  type: for query params, title: for text on chips
 */
enum class DisasterEnum(override val type: String, override val filterText: String): DisasterTypes {
    WIND(DisasterType.WIND, DisasterFilterText.WIND),
    FLOOD(DisasterType.FLOOD, DisasterFilterText.FLOOD),
    HAZE(DisasterType.HAZE, DisasterFilterText.HAZE),
    EARTHQUAKE(DisasterType.EARTHQUAKE, DisasterFilterText.EARTHQUAKE),
    VOLCANO(DisasterType.VOLCANO, DisasterFilterText.VOLCANO),
    FIRE(DisasterType.FIRE, DisasterFilterText.FIRE),
}
