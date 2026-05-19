package io.aristiyo.capstone.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.aristiyo.core.domain.model.Team
import io.aristiyo.core.domain.usecase.TeamUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailTeamViewModel @Inject constructor(private val teamUseCase: TeamUseCase) : ViewModel() {

    fun saveFavouriteTeam(team: Team, isFavourite: Boolean) {
        viewModelScope.launch {
            teamUseCase.saveFavouriteTeam(team, isFavourite)
        }
    }
}