package com.example.janintriassignment.data.db.repository

import com.preg.vita.data.HealthDataDao

import com.example.janintriassignment.data.db.model.HealthModel
import javax.inject.Inject

class HealthDataRepository @Inject constructor(
    private val healthDataDao: HealthDataDao
) {
    fun getAllData() = healthDataDao.getAllData()
    suspend fun insertData(healthData: HealthModel) = healthDataDao.insertData(healthData)
}