package io.aristiyo.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.aristiyo.core.domain.repository.ITeamsRepository
import io.aristiyo.core.source.TeamRepository

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(teamRepository: TeamRepository): ITeamsRepository
}
