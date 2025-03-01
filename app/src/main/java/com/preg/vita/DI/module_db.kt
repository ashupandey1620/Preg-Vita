package com.example.janintriassignment.di.modules

import android.content.Context
import androidx.room.Room
import com.preg.vita.data.HealthDataDao
import com.preg.vita.data.HealthDatabase
import com.example.janintriassignment.data.db.repository.HealthDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): HealthDatabase {
        return Room.databaseBuilder(context, HealthDatabase::class.java, "health_db").build()
    }

    @Provides
    fun provideHealthDataDao(database: HealthDatabase): HealthDataDao {
        return database.healthDataDao()
    }

    @Provides
    @Singleton
    fun provideHealthDataRepository(dao: HealthDataDao): HealthDataRepository {
        return HealthDataRepository(dao)
    }
}
