package com.preg.vita

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class PregApp: Application() {
    override fun onCreate() {
        super.onCreate()


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // Create the NotificationChannel.
            val name = CHANNEL_NAME
            val descriptionText = "Daily Chronicles Reminder Notification"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            mChannel.description = descriptionText
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }
    }

    companion object{
        const val CHANNEL_ID = "channel_id"
        const val CHANNEL_NAME = "Log Vitals Reminder"
    }
}