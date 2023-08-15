package com.rahdeva.bencanaapp.domain.usecase

import com.rahdeva.bencanaapp.domain.model.DisasterItems
import com.rahdeva.bencanaapp.utils.DataResults

interface DisasterUseCase {
    suspend fun getDisaster(): DataResults<List<DisasterItems?>?>
    suspend fun searchDisaster(admin: String): DataResults<List<DisasterItems?>?>
    suspend fun getFilterDisaster(disasterType: String): DataResults<List<DisasterItems?>?>
    suspend fun getDisasterByLocationAndType(location: String, type: String): DataResults<List<DisasterItems?>?>
}