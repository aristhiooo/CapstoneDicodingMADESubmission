package io.aristiyo.favouritefeature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import io.aristiyo.core.domain.usecase.TeamUseCase

class FavouriteViewModel(
    teamUseCase: TeamUseCase,
) : ViewModel() {
    val favouriteTeamList = teamUseCase.getFavouriteTeam().asLiveData()
}
