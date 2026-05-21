package io.aristiyo.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.aristiyo.core.BuildConfig
import io.aristiyo.core.source.local.roomdb.AppDatabase
import io.aristiyo.core.source.local.roomdb.TeamDao
import net.zetetic.database.sqlcipher.SupportOpenHelperFactory
import java.nio.charset.StandardCharsets
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase {
        System.loadLibrary("sqlcipher")
        val factory =
            SupportOpenHelperFactory(
                BuildConfig.ENCRYPTION_PASSWORD.toByteArray(
                    StandardCharsets.UTF_8,
                ),
            )
        return Room
            .databaseBuilder(
                context,
                AppDatabase::class.java,
                "Teams.db",
            ).fallbackToDestructiveMigration(false)
            .openHelperFactory(factory)
            .build()
    }

    @Provides
    fun provideTeamDao(database: AppDatabase): TeamDao = database.teamDao()
}
