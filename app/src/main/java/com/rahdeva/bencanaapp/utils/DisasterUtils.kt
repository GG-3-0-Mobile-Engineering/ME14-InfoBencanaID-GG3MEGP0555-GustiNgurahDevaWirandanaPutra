package com.rahdeva.bencanaapp.utils

import android.content.Context
import android.graphics.drawable.Drawable
import com.rahdeva.bencanaapp.R
import com.rahdeva.bencanaapp.domain.model.DisasterEnum


class DisasterUtils(private val appContext: Context) {
    fun getRegionCode(location: String): String {
        return when(location) {
            appContext.getString(R.string.city_aceh) -> { "ID-AC" }
            appContext.getString(R.string.city_bali) -> { "ID-BA" }
            appContext.getString(R.string.city_banten) -> { "ID-BT" }
            appContext.getString(R.string.city_bengkulu) -> { "ID-BE" }
            appContext.getString(R.string.city_jawa_tengah) -> { "ID-JT" }
            appContext.getString(R.string.city_kalimantan_tengah) -> { "ID-KT" }
            appContext.getString(R.string.city_sulawesi_tengah) -> { "ID-ST" }
            appContext.getString(R.string.city_jawa_timur) -> { "ID-JI" }
            appContext.getString(R.string.city_kalimantan_timur) -> { "ID-KI" }
            appContext.getString(R.string.city_nusa_tenggara_timur) -> { "ID-NT" }
            appContext.getString(R.string.city_gorontalo) -> { "ID-GO" }
            appContext.getString(R.string.city_dki_jakarta) -> { "ID-JK"}
            appContext.getString(R.string.city_jambi) -> { "ID-JA" }
            appContext.getString(R.string.city_lampung) -> { "ID-LA" }
            appContext.getString(R.string.city_maluku) -> { "ID-MA" }
            appContext.getString(R.string.city_kalimantan_utara) -> { "ID-KU" }
            appContext.getString(R.string.city_maluku_utara) -> { "ID-MU" }
            appContext.getString(R.string.city_sulawesi_utara) -> { "ID-SA" }
            appContext.getString(R.string.city_sumatera_utara) -> { "ID-SU" }
            appContext.getString(R.string.city_papua) -> { "ID-PA" }
            appContext.getString(R.string.city_riau) -> { "ID-RI" }
            appContext.getString(R.string.city_kepulauan_riau) -> { "ID-KR" }
            appContext.getString(R.string.city_sulawesi_tenggara) -> { "ID-SG" }
            appContext.getString(R.string.city_kalimantan_selatan) -> { "ID-KS" }
            appContext.getString(R.string.city_sulawesi_selatan) -> { "ID-SN" }
            appContext.getString(R.string.city_sumatera_selatan) -> { "ID-SS" }
            appContext.getString(R.string.city_di_yogyakarta) -> { "ID-YO" }
            appContext.getString(R.string.city_jawa_barat) -> { "ID-JB" }
            appContext.getString(R.string.city_kalimantan_barat) -> { "ID-KB" }
            appContext.getString(R.string.city_nusa_tenggara_barat) -> { "ID-NB" }
            appContext.getString(R.string.city_papua_barat) -> { "ID-PB" }
            appContext.getString(R.string.city_sulawesi_barat) -> { "ID-SR" }
            appContext.getString(R.string.city_sumatera_barat) -> { "ID-SB" }
            else -> { "" }
        }
    }

    fun getRegionString(code: String): String {
        val location = when (code) {
            "ID-AC" -> { appContext.getString(R.string.city_aceh) }
            "ID-BA" -> { appContext.getString(R.string.city_bali) }
            "ID-BT" -> { appContext.getString(R.string.city_banten) }
            "ID-BE" -> { appContext.getString(R.string.city_bengkulu) }
            "ID-JT" -> { appContext.getString(R.string.city_jawa_tengah) }
            "ID-KT" -> { appContext.getString(R.string.city_kalimantan_tengah) }
            "ID-ST" -> { appContext.getString(R.string.city_sulawesi_tengah) }
            "ID-JI" -> { appContext.getString(R.string.city_jawa_timur) }
            "ID-KI" -> { appContext.getString(R.string.city_kalimantan_timur) }
            "ID-NT" -> { appContext.getString(R.string.city_nusa_tenggara_timur) }
            "ID-GO" -> { appContext.getString(R.string.city_gorontalo) }
            "ID-JK" -> { appContext.getString(R.string.city_dki_jakarta) }
            "ID-JA" -> { appContext.getString(R.string.city_jambi) }
            "ID-LA" -> { appContext.getString(R.string.city_lampung) }
            "ID-MA" -> { appContext.getString(R.string.city_maluku) }
            "ID-KU" -> { appContext.getString(R.string.city_kalimantan_utara) }
            "ID-MU" -> { appContext.getString(R.string.city_maluku_utara) }
            "ID-SA" -> { appContext.getString(R.string.city_sulawesi_utara) }
            "ID-SU" -> { appContext.getString(R.string.city_sumatera_utara) }
            "ID-PA" -> { appContext.getString(R.string.city_papua) }
            "ID-RI" -> { appContext.getString(R.string.city_riau) }
            "ID-KR" -> { appContext.getString(R.string.city_kepulauan_riau) }
            "ID-SG" -> { appContext.getString(R.string.city_sulawesi_tenggara) }
            "ID-KS" -> { appContext.getString(R.string.city_kalimantan_selatan) }
            "ID-SN" -> { appContext.getString(R.string.city_sulawesi_selatan) }
            "ID-SS" -> { appContext.getString(R.string.city_sumatera_selatan) }
            "ID-YO" -> { appContext.getString(R.string.city_di_yogyakarta) }
            "ID-JB" -> { appContext.getString(R.string.city_jawa_barat) }
            "ID-KB" -> { appContext.getString(R.string.city_kalimantan_barat) }
            "ID-NB" -> { appContext.getString(R.string.city_nusa_tenggara_barat) }
            "ID-PB" -> { appContext.getString(R.string.city_papua_barat) }
            "ID-SR" -> { appContext.getString(R.string.city_sulawesi_barat) }
            "ID-SB" -> {
                appContext.getString(R.string.city_sumatera_barat) }
            else -> { "" }
        }
        return location
    }

    fun getDisasterType(disasterType: String?): String {
        return when (disasterType) {
            appContext.getString(R.string.flood) -> DisasterEnum.FLOOD.filterText
            appContext.getString(R.string.haze) -> DisasterEnum.HAZE.filterText
            appContext.getString(R.string.wind) -> DisasterEnum.WIND.filterText
            appContext.getString(R.string.earthquake) -> DisasterEnum.EARTHQUAKE.filterText
            appContext.getString(R.string.volcano) -> DisasterEnum.VOLCANO.filterText
            appContext.getString(R.string.fire) -> DisasterEnum.FIRE.filterText
            else -> appContext.getString(R.string.unknown)
        }
    }

    fun getMarkerIcon(disasterType: String?): Int {
        return when (disasterType) {
            appContext.getString(R.string.flood) -> R.drawable.ic_location_flood
            appContext.getString(R.string.haze) -> R.drawable.ic_location_haze
            appContext.getString(R.string.wind) -> R.drawable.ic_location_wind
            appContext.getString(R.string.earthquake) -> R.drawable.ic_location_earthquake
            appContext.getString(R.string.volcano) -> R.drawable.ic_location_volcano
            appContext.getString(R.string.fire) -> R.drawable.ic_location_fire
            else -> R.drawable.ic_not_listed_location_24
        }
    }

    fun getDisasterDefaultImg(disasterType: String?): Int {

        return when(disasterType) {
            appContext.getString(R.string.flood) -> R.drawable.img_flood
            appContext.getString(R.string.haze) -> R.drawable.img_haze
            appContext.getString(R.string.wind) -> R.drawable.img_wind
            appContext.getString(R.string.earthquake) -> R.drawable.img_earthquake
            appContext.getString(R.string.volcano) -> R.drawable.img_volcano
            appContext.getString(R.string.fire) -> R.drawable.img_fire
            else -> R.drawable.ic_not_listed_location_24
        }

    }

    fun getWarningImage(warningText: String): Drawable? {
        return when (warningText) {
            appContext.getString(R.string.warning_no_data) -> appContext.getDrawable(R.drawable.img_no_data)
            appContext.getString(R.string.warning_not_found) -> appContext.getDrawable(R.drawable.img_not_found)
            appContext.getString(R.string.warning_exception) -> appContext.getDrawable(R.drawable.img_exception)
            else -> appContext.getDrawable(R.drawable.img_exception)
        }
    }

}