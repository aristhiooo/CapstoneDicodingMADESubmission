package io.aristiyo.favouritefeature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.aristiyo.core.domain.usecase.TeamUseCase
import javax.inject.Inject

class ViewModelFactory
    @Inject
    constructor(
        private val teamUseCase: TeamUseCase,
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            when {
                modelClass.isAssignableFrom(FavouriteViewModel::class.java) -> {
                    FavouriteViewModel(teamUseCase) as T
                }
                else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
            }
    }
