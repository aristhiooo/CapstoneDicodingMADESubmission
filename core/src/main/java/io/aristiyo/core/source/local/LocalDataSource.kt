package io.aristiyo.core.source.local

import io.aristiyo.core.source.local.entity.TeamEntity
import io.aristiyo.core.source.local.roomdb.TeamDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource
    @Inject
    constructor(
        private val teamDao: TeamDao,
    ) {
        fun getAllTeams(): Flow<List<TeamEntity>> = teamDao.getAllTeams()

        fun getFavouriteTeams(): Flow<List<TeamEntity>> = teamDao.getFavoriteTeams()

        suspend fun insertTeams(teams: List<TeamEntity>) = teamDao.insertAll(teams)

        suspend fun saveFavouriteTeam(
            team: TeamEntity,
            newState: Boolean,
        ) {
            team.isFavourite = newState
            teamDao.updateFavoriteTeam(team)
        }
    }
