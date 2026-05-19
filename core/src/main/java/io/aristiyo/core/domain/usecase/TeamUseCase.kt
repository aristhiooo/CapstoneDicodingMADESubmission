package io.aristiyo.core.domain.usecase

import io.aristiyo.core.domain.model.Team
import io.aristiyo.core.source.ResultStatus
import kotlinx.coroutines.flow.Flow

interface TeamUseCase {

    fun getAllTeams(): Flow<ResultStatus<List<Team>>>

    fun getFavouriteTeam(): Flow<List<Team>>

    suspend fun saveFavouriteTeam(team: Team, isFavourite: Boolean)
}