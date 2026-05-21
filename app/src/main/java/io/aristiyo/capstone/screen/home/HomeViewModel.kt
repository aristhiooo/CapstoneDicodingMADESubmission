package io.aristiyo.capstone.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.aristiyo.core.domain.usecase.TeamUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        teamUseCase: TeamUseCase,
    ) : ViewModel() {
        val teamList = teamUseCase.getAllTeams().asLiveData()
    }
