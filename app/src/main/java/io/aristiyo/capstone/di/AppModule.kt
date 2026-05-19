package io.aristiyo.capstone.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.aristiyo.core.domain.usecase.TeamInteractor
import io.aristiyo.core.domain.usecase.TeamUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideTeamUseCase(teamIterator: TeamInteractor): TeamUseCase
}