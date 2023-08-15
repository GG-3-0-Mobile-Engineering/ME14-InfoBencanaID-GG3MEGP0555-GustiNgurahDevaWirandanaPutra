package com.rahdeva.bencanaapp.utils.notification

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.rahdeva.bencanaapp.domain.model.DisasterItems
import com.rahdeva.bencanaapp.domain.usecase.DisasterUseCase
import com.rahdeva.bencanaapp.utils.DataResults
import com.rahdeva.bencanaapp.utils.notification.NotificationBuilder.showNotification
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class NotificationWorker @Inject constructor(private val useCase: DisasterUseCase, appContext: Context, workerParams: WorkerParameters) : CoroutineWorker(appContext, workerParams) {

    private var job: Job? = null
    private var disasterReports = arrayListOf<DisasterItems?>()

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        job = launch {
            try {
                useCase.getDisaster().apply {
                    when (this) {
                        is DataResults.Success -> { this.data?.let { disasterReports.addAll(it) } }
                        is DataResults.Error -> {  }
                    }
                }
            } catch (e: Exception){
                Log.e("NotificationWorker", e.toString())
            }
        }
        job?.join()
        while (!isStopped) {
            showNotification(disasterReports, applicationContext)
            Thread.sleep(TimeUnit.MINUTES.toMillis(15))
        }
        Result.success()
    }

}