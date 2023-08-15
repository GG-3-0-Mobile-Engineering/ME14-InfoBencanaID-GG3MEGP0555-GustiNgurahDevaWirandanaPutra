package com.rahdeva.bencanaapp.disasterRepositoryTest

import com.rahdeva.bencanaapp.domain.model.Output
import com.rahdeva.bencanaapp.domain.repository.DisasterRepository
import com.rahdeva.bencanaapp.utils.DataResults
import com.rahdeva.bencanaapp.utils.testing.getDisasterItems
import com.rahdeva.bencanaapp.utils.testing.loadJson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class DisasterRepositoryTest {
    private var disasterRepository: DisasterRepository = mock()
    private val coroutineTestDispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(coroutineTestDispatcher)
    }

    @Test
    fun `DisasterRepository-getDisaster() = should return list of disasterItems`(){
        runBlocking {
            val expectedValue = DataResults.Success(getDisasterItems())

            whenever(disasterRepository.getDisaster())
                .thenReturn(expectedValue)

            disasterRepository.getDisaster().apply {
                val json = loadJson(Output::class.java, "response/disaster_schema.json")
                val actualValue = DataResults.Success(json?.geometries)

                assertEquals(expectedValue, actualValue)
            }

            verify(disasterRepository).getDisaster()
        }
    }

    @Test
    fun `DisasterRepository-searchDisaster() = should return list of disasterItems `(){
        runBlocking {
            val expectedValue = DataResults.Success(getDisasterItems())
            val adminStr = "ID-AC"

            whenever(disasterRepository.searchDisaster(adminStr))
                .thenReturn(expectedValue)

            disasterRepository.searchDisaster(adminStr).apply {
                val json = loadJson(Output::class.java, "response/disaster_schema.json")
                val actualValue = DataResults.Success(json?.geometries)

                assertEquals(expectedValue, actualValue)
            }

            verify(disasterRepository).searchDisaster(adminStr)
        }
    }

    @Test
    fun `DisasterRepository-getFilterDisaster() = should return list of disasterItems`(){
        runBlocking {
            val expectedValue = DataResults.Success(getDisasterItems())
            val disasterType = "flood"

            whenever(disasterRepository.getFilterDisaster(disasterType))
                .thenReturn(expectedValue)

            disasterRepository.getFilterDisaster(disasterType).apply {
                val json = loadJson(Output::class.java, "response/disaster_schema.json")
                val actualValue = DataResults.Success(json?.geometries)

                assertEquals(expectedValue, actualValue)
            }

            verify(disasterRepository).getFilterDisaster(disasterType)
        }
    }

    @Test
    fun `DisasterRepository-getDisasterByLocationAndType() = should return list of disasterItems`(){
        runBlocking {
            val expectedValue = DataResults.Success(getDisasterItems())
            val disasterType = "flood"
            val location = "ID-AC"

            whenever(disasterRepository.getDisasterByLocationAndType(location, disasterType))
                .thenReturn(expectedValue)

            disasterRepository.getDisasterByLocationAndType(location, disasterType).apply {
                val json = loadJson(Output::class.java, "response/disaster_schema.json")
                val actualValue = DataResults.Success(json?.geometries)

                assertEquals(expectedValue, actualValue)
            }

            verify(disasterRepository).getDisasterByLocationAndType(location, disasterType)
        }
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

}