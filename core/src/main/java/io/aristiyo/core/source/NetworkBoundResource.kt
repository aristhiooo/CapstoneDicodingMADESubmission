package io.aristiyo.core.source

import io.aristiyo.core.source.remote.ApiStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class NetworkBoundResource<ResultType, RequestType> {
    protected open fun onFetchFailed() = Unit

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiStatus<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<ResultStatus<ResultType>> =
        flow {
            emit(ResultStatus.Loading())
            val dbSource = loadFromDB().first()
            if (shouldFetch(dbSource)) {
                emit(ResultStatus.Loading())
                when (val apiResponse = createCall().first()) {
                    is ApiStatus.Success -> {
                        saveCallResult(apiResponse.data)
                        emitAll(loadFromDB().map { ResultStatus.Success(it) })
                    }

                    is ApiStatus.Error -> {
                        onFetchFailed()
                        emit(ResultStatus.Error(apiResponse.errorMessage))
                    }

                    is ApiStatus.Empty -> emitAll(loadFromDB().map { ResultStatus.Success(it) })
                }
            } else {
                emitAll(loadFromDB().map { ResultStatus.Success(it) })
            }
        }
}
