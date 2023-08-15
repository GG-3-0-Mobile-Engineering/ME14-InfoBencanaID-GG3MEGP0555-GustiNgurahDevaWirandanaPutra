package com.rahdeva.bencanaapp.utils.testing

import androidx.lifecycle.MutableLiveData
import com.rahdeva.bencanaapp.domain.model.DisasterItems
import com.rahdeva.bencanaapp.domain.model.DisasterProperty
import com.rahdeva.bencanaapp.domain.model.FireLocation
import com.rahdeva.bencanaapp.domain.model.FireRadius
import com.rahdeva.bencanaapp.domain.model.PersonLocation
import com.rahdeva.bencanaapp.domain.model.ReportData
import com.rahdeva.bencanaapp.domain.model.Tags
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okio.buffer
import okio.source
import java.util.Date

fun getDisasterItems() =
    mutableListOf(
        DisasterItems(
            coordinates = listOf(12.345, -67.890),
            type = "Point",
            disasterProperty = getDisasterProperty(),
            arcs = listOf(listOf(1, 2, 3))
        ),
        DisasterItems(
            coordinates = listOf(23.456, -78.901),
            type = "Point",
            disasterProperty = getDisasterProperty(),
            arcs = listOf(listOf(4, 5, 6))
        ),
        DisasterItems(
            coordinates = listOf(34.567, -89.012),
            type = "Point",
            disasterProperty = getDisasterProperty(),
            arcs = listOf(listOf(7, 8, 9))
        )
    )

fun getDisasterProperty(): DisasterProperty =
    DisasterProperty(
        imageUrl = "https://example.com/image.jpg",
        disasterType = "Flood",
        createdAt = "Sun Aug 15 2023 09:00:00 GMT+0000 (Coordinated Universal Time)",
        source = "News Channel XYZ",
        title = "Severe Flooding in City A",
        url = "https://example.com/news/123",
        tags = Tags(
            instanceRegionCode = "INST123",
            districtId = 1,
            localAreaId = 123,
            regionCode = "REG456"
        ),
        reportData = ReportData(
            personLocation = PersonLocation(
                    lng = 45.678, lat = -123.456
            ),
            fireLocation = FireLocation(
                lng = 45.678, lat = -123.456
            ),
            reportType = "Emergency",
            fireRadius = FireRadius(
                lng = 45.678, lat = -123.456
            ),
            fireDistance = 5.0,
            structureFailure = 2,
            airQuality = 3,
            visibility = 4,
            floodDepth = 10,
            volcanicSigns = listOf(1, 2, 3),
            evacuationArea = true,
            evacuationNumber = 100
        ),
        pkey = "abcdef123456",
        text = "Heavy rainfall has caused widespread flooding...",
        status = "Ongoing",
        areaName = "City A",
        parentName = "State X",
        cityName = "City A",
        lastUpdated = "Sun Aug 15 2023 09:00:00 GMT+0000 (Coordinated Universal Time)",
        geomId = "geo-123",
        state = 1,
        areaId = "area-456"
    )

// Help to deserialize json schema to our respective dto for testing purpose
fun <T> loadJson(clss: Class<T>, file: String): T? {
    val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    val jsonAdapter: JsonAdapter<T> = moshi.adapter(clss)

    val fixtureStreamReader = clss.classLoader?.getResourceAsStream(file)?.source()?.buffer() ?: throw IllegalArgumentException("File not found: $file")
    val jsonReader = JsonReader.of(fixtureStreamReader)
    return jsonAdapter.fromJson(jsonReader)
}
