package com.rahdeva.bencanaapp.domain.usecase

import com.rahdeva.bencanaapp.domain.model.DisasterItems
import com.rahdeva.bencanaapp.domain.repository.DisasterRepository
import com.rahdeva.bencanaapp.utils.DataResults

class DisasterUseCaseImpl(private val repository: DisasterRepository): DisasterUseCase {
    override suspend fun getDisaster(): DataResults<List<DisasterItems?>?> {
        return repository.getDisaster()
    }

    override suspend fun searchDisaster(admin: String): DataResults<List<DisasterItems?>?> {
        return repository.searchDisaster(admin)
    }

    override suspend fun getFilterDisaster(disasterType: String): DataResults<List<DisasterItems?>?> {
        return repository.getFilterDisaster(disasterType)
    }

    override suspend fun getDisasterByLocationAndType(
        location: String,
        type: String
    ): DataResults<List<DisasterItems?>?> {
        return repository.getDisasterByLocationAndType(location, type)
    }

}