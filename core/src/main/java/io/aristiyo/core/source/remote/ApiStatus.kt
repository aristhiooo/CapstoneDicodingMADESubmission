package io.aristiyo.core.source.remote

sealed class ApiStatus<out R> {
    data class Success<out T>(
        val data: T,
    ) : ApiStatus<T>()

    data class Error(
        val errorMessage: String,
    ) : ApiStatus<Nothing>()

    data object Empty : ApiStatus<Nothing>()
}
