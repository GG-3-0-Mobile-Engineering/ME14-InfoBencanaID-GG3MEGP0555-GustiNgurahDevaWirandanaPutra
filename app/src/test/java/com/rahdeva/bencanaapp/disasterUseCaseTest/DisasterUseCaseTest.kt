package com.rahdeva.bencanaapp.disasterUseCaseTest

import com.rahdeva.bencanaapp.domain.model.Output
import com.rahdeva.bencanaapp.domain.usecase.DisasterUseCase
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
class DisasterUseCaseTest {
    private var disasterUseCase: DisasterUseCase = mock()
    private val coroutineDispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(coroutineDispatcher)
    }

    @Test
    fun `DisasterUseCase-getDisaster() = should return list of disasterItems`(){
        runBlocking {
            val expectedValue = DataResults.Success(getDisasterItems())

            whenever(disasterUseCase.getDisaster())
                .thenReturn(expectedValue)

            disasterUseCase.getDisaster().apply {
                val json = loadJson(Output::class.java, "response/disaster_schema.json")
                val actualValue = DataResults.Success(json?.geometries)

                assertEquals(expectedValue, actualValue)
            }

            verify(disasterUseCase).getDisaster()
        }
    }

    @Test
    fun `DisasterUseCase-searchDisaster() = should return list of disasterItems`(){
        runBlocking {
            val expectedValue = DataResults.Success(getDisasterItems())
            val adminStr = "ID-AC"

            whenever(disasterUseCase.searchDisaster(adminStr))
                .thenReturn(expectedValue)

            disasterUseCase.searchDisaster(adminStr).apply {
                val json = loadJson(Output::class.java, "response/disaster_schema.json")
                val actualValue = DataResults.Success(json?.geometries)

                assertEquals(expectedValue, actualValue)
            }

            verify(disasterUseCase).searchDisaster(adminStr)
        }
    }

    @Test
    fun `DisasterUseCase-getFilterDisaster() = should return list of disasterItems`(){
        runBlocking {
            val expectedValue = DataResults.Success(getDisasterItems())
            val disasterType = "flood"

            whenever(disasterUseCase.getFilterDisaster(disasterType))
                .thenReturn(expectedValue)

            disasterUseCase.getFilterDisaster(disasterType).apply {
                val json = loadJson(Output::class.java, "response/disaster_schema.json")
                val actualValue = DataResults.Success(json?.geometries)

                assertEquals(expectedValue, actualValue)
            }

            verify(disasterUseCase).getFilterDisaster(disasterType)
        }
    }

    @Test
    fun `DisasterUseCase-getDisasterByLocationAndType() = should return list of disasterItems`(){
        runBlocking {
            val expectedValue = DataResults.Success(getDisasterItems())
            val disasterType = "flood"
            val location = "ID-AC"

            whenever(disasterUseCase.getDisasterByLocationAndType(location, disasterType))
                .thenReturn(expectedValue)

            disasterUseCase.getDisasterByLocationAndType(location, disasterType).apply {
                val json = loadJson(Output::class.java, "response/disaster_schema.json")
                val actualValue = DataResults.Success(json?.geometries)

                assertEquals(expectedValue, actualValue)
            }

            verify(disasterUseCase).getDisasterByLocationAndType(location, disasterType)
        }
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

}