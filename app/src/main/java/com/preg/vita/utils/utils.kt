package com.example.janintriassignment.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun getCurrentTimeFormatted(): String {
    val formatter = SimpleDateFormat("EEE, dd MMM yyyy hh:mm a", Locale.ENGLISH)
    val currentTime = Date()
    return formatter.format(currentTime)
}