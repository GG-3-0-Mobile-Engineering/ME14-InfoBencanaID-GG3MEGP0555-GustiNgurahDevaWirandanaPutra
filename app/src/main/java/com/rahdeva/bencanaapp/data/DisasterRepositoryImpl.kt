package com.rahdeva.bencanaapp.data

import com.rahdeva.bencanaapp.data.api.ApiService
import com.rahdeva.bencanaapp.domain.model.DisasterItems
import com.rahdeva.bencanaapp.domain.repository.DisasterRepository
import com.rahdeva.bencanaapp.utils.DataResults


class DisasterRepositoryImpl(private val service: ApiService): DisasterRepository  {
    override suspend fun getDisaster(): DataResults<List<DisasterItems?>?> {
        return try {
            val res = service.getDisasters()
            if(res.result?.objects?.output?.geometries!!.isNotEmpty()) {
                DataResults.Success(res.result.objects.output.geometries)
            } else {
                DataResults.Error("Disaster Not Found!")
            }
        } catch (ex: Exception){
            DataResults.Error("Network Error: $ex")
        }
    }

    override suspend fun searchDisaster(admin: String): DataResults<List<DisasterItems?>?> {
        return try {
            val res = service.getDisastersByLocation(admin)
            if(res.result?.objects?.output?.geometries!!.isNotEmpty()) {
                DataResults.Success(res.result.objects.output.geometries)
            } else {
                DataResults.Error("Disaster Not Found!")
            }
        } catch (ex: Exception){
            DataResults.Error("Network Error: $ex")
        }
    }

    override suspend fun getFilterDisaster(disasterType: String): DataResults<List<DisasterItems?>?> {
        return try {
            val res = service.getDisastersByType(disasterType)
            if(res.result?.objects?.output?.geometries!!.isNotEmpty()) {
                DataResults.Success(res.result.objects.output.geometries)
            } else {
                DataResults.Error("Disaster Not Found!")
            }
        } catch (ex: Exception){
            DataResults.Error("Network Error: $ex")
        }
    }

    override suspend fun getDisasterByLocationAndType(location: String, type: String): DataResults<List<DisasterItems?>?> {
        return try {
            val res = service.getDisastersByLocationAndType(location, type)
            if(res.result?.objects?.output?.geometries!!.isNotEmpty()) {
                DataResults.Success(res.result.objects.output.geometries)
            } else {
                DataResults.Error("Disaster Not Found!")
            }
        } catch (ex: Exception){
            DataResults.Error("Network Error: $ex")
        }
    }
}