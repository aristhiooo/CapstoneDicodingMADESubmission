package io.aristiyo.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.aristiyo.core.source.local.roomdb.AppDatabase
import io.aristiyo.core.source.local.roomdb.TeamDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "Teams.db"
        ).fallbackToDestructiveMigration(false).build()
    }

    @Provides
    fun provideTeamDao(database: AppDatabase): TeamDao {
        return database.teamDao()
    }
}