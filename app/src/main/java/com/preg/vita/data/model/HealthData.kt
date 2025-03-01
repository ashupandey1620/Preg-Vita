package com.example.janintriassignment.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "health_data")
data class HealthData(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "heart_rate") var heartRate: Int,
    @ColumnInfo(name = "sys_bp") var sysBp: Int,
    @ColumnInfo(name = "dia_bp") var diaBp: Int,
    @ColumnInfo(name = "weight") var weight: Int,
    @ColumnInfo(name = "kicks") var kicks: Int,
    @ColumnInfo(name = "timestamp") var timestamp: String,
)