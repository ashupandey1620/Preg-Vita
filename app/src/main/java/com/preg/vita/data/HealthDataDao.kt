package com.preg.vita.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.janintriassignment.data.db.model.HealthModel


import kotlinx.coroutines.flow.Flow

@Dao
interface HealthDataDao {
    @Query("SELECT * FROM vital_data")
    fun getAllData(): Flow<List<HealthModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(healthData: HealthModel)
}