package com.preg.vita.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.janintriassignment.data.db.model.HealthData

@Database(entities = [HealthData::class], version = 1, exportSchema = false)
abstract class HealthDatabase: RoomDatabase() {
    abstract fun healthDataDao(): HealthDataDao
}