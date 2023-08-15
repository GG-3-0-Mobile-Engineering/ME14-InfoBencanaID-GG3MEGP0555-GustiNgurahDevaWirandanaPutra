package com.rahdeva.bencanaapp.data.api

import com.rahdeva.bencanaapp.domain.model.DisasterResponse
import com.rahdeva.bencanaapp.utils.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("reports")
    suspend fun getDisasters(
        @Query("timeperiod") timePeriod: Int = Constant.DISASTER_TIME_PERIOD
    ): DisasterResponse

    @GET("reports")
    suspend fun getDisastersByLocationAndType(
        @Query("admin") admin: String,
        @Query("disaster") disaster: String,
        @Query("timeperiod") timePeriod: Int = Constant.DISASTER_TIME_PERIOD
    ): DisasterResponse

    @GET("reports")
    suspend fun getDisastersByLocation(
        @Query("admin") admin: String,
        @Query("timeperiod") timePeriod: Int = Constant.DISASTER_TIME_PERIOD
    ): DisasterResponse

    @GET("reports")
    suspend fun getDisastersByType(
        @Query("disaster") disaster: String,
        @Query("timeperiod") timePeriod: Int = Constant.DISASTER_TIME_PERIOD
    ): DisasterResponse

}