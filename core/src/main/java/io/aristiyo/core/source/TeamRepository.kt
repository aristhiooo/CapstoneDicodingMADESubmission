package io.aristiyo.core.source

import io.aristiyo.core.domain.model.Team
import io.aristiyo.core.domain.repository.ITeamsRepository
import io.aristiyo.core.source.local.LocalDataSource
import io.aristiyo.core.source.remote.ApiStatus
import io.aristiyo.core.source.remote.RemoteDataSource
import io.aristiyo.core.source.remote.response.TeamDto
import io.aristiyo.core.utils.toDomainList
import io.aristiyo.core.utils.toEntity
import io.aristiyo.core.utils.toEntityList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamRepository
    @Inject
    constructor(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
    ) : ITeamsRepository {
        override fun getAllTeams(): Flow<ResultStatus<List<Team>>> =
            object : NetworkBoundResource<List<Team>, List<TeamDto>>() {
                override fun loadFromDB(): Flow<List<Team>> =
                    localDataSource.getAllTeams().map {
                        it.toDomainList()
                    }

                override fun shouldFetch(data: List<Team>?): Boolean = data.isNullOrEmpty()

                override suspend fun createCall(): Flow<ApiStatus<List<TeamDto>>> = remoteDataSource.getAllTeams()

                override suspend fun saveCallResult(data: List<TeamDto>) {
                    val teamList = data.toEntityList()
                    localDataSource.insertTeams(teamList)
                }
            }.asFlow()

        override fun getFavouriteTeam(): Flow<List<Team>> =
            localDataSource.getFavouriteTeams().map {
                it.toDomainList()
            }

        override suspend fun saveFavouriteTeam(
            team: Team,
            state: Boolean,
        ) {
            val teamEntity = team.toEntity()
            localDataSource.saveFavouriteTeam(teamEntity, state)
        }
    }
