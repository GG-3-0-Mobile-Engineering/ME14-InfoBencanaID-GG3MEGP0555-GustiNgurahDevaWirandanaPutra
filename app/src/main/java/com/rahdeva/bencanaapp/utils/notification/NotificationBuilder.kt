package com.rahdeva.bencanaapp.utils.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.rahdeva.bencanaapp.R
import com.rahdeva.bencanaapp.domain.model.DisasterItems
import com.rahdeva.bencanaapp.utils.Constant.CHANNEL_ID
import com.rahdeva.bencanaapp.utils.Constant.CHANNEL_NAME
import com.rahdeva.bencanaapp.utils.Constant.NOTIFICATION_ID_WARNING

object NotificationBuilder {

    fun showNotification(disasterReports: ArrayList<DisasterItems?>, appContext: Context) {
        showDisasterWarningNotification(appContext,
            title = "Bencana Terdeteksi!",
            description = "Lokasi bencana: ${disasterReports.first()?.disasterProperty?.cityName}}"
        )
    }

    private fun showDisasterWarningNotification(appContext: Context ,title: String, description: String?) {
        val notificationManager = appContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification: NotificationCompat.Builder = NotificationCompat.Builder(appContext, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification_important_24)
            .setContentTitle(title)
            .setContentText(description)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH)
            notification.setChannelId(CHANNEL_ID)
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(NOTIFICATION_ID_WARNING, notification.build())
    }

}