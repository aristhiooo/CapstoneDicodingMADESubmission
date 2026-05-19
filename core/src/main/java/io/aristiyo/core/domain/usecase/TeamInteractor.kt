package io.aristiyo.core.domain.usecase

import io.aristiyo.core.domain.model.Team
import io.aristiyo.core.domain.repository.ITeamsRepository
import io.aristiyo.core.source.ResultStatus
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TeamInteractor @Inject constructor(private val teamRepository: ITeamsRepository) : TeamUseCase {

    override fun getAllTeams(): Flow<ResultStatus<List<Team>>> {
        return teamRepository.getAllTeams()
    }

    override fun getFavouriteTeam(): Flow<List<Team>> {
        return teamRepository.getFavouriteTeam()
    }

    override suspend fun saveFavouriteTeam(team: Team, isFavourite: Boolean) {
        teamRepository.saveFavouriteTeam(team, isFavourite)
    }
}