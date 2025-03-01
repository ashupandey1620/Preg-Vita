package com.preg.vita

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.janintriassignment.ui.screens.home_screen.HomeScreen
import com.example.janintriassignment.worker.NotificationWorker
import com.preg.vita.ui.theme.PregVitaTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit


@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCompat.requestPermissions(
            this ,
            arrayOf(android.Manifest.permission.POST_NOTIFICATIONS) ,
            0
        )
        enableEdgeToEdge()
        setContent {
            PregVitaTheme {
                HomeScreen()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int ,
        permissions: Array<out String> ,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode , permissions , grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            scheduleNotificationWork()
        }
    }

    private fun scheduleNotificationWork() {
        Log.d("ScheduledNotification" , "Scheduled")
        val workRequest = PeriodicWorkRequestBuilder<NotificationWorker>(5 , TimeUnit.HOURS)
            .build()
        WorkManager.getInstance(application).enqueueUniquePeriodicWork(
            "notification_work" ,
            ExistingPeriodicWorkPolicy.KEEP , workRequest
        )
    }

}