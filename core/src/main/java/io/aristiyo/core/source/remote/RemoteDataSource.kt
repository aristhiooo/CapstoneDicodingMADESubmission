package io.aristiyo.core.source.remote

import io.aristiyo.core.source.remote.response.TeamDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    fun getAllTeams(): Flow<ApiStatus<List<TeamDto>>> = flow {
        try {
            val response = apiService.getTeamsList()
            val data = response.teams
            if (!data.isNullOrEmpty()) {
                emit(ApiStatus.Success(data))
            } else {
                emit(ApiStatus.Empty)
            }
        } catch (error: Throwable) {
            Timber.e(error)
        }
    }.flowOn(Dispatchers.IO)
}