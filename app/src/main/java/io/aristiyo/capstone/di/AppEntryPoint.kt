package io.aristiyo.capstone.di

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.aristiyo.core.domain.usecase.TeamUseCase

@EntryPoint
@InstallIn(SingletonComponent::class)
interface AppEntryPoint {

    fun teamUseCase(): TeamUseCase
}