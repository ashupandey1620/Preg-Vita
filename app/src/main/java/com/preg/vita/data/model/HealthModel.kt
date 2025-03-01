package com.example.janintriassignment.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vital_data")
data class HealthModel(
    @ColumnInfo(name = "heart") var heartRate: Int,
    @ColumnInfo(name = "sys") var sysBp: Int,
    @ColumnInfo(name = "dia") var diaBp: Int,
    @ColumnInfo(name = "weight") var weight: Int,
    @ColumnInfo(name = "kicks") var kicks: Int,
    @ColumnInfo(name = "timestamp") var timestamp: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "uid") var id: Int = 0,
)