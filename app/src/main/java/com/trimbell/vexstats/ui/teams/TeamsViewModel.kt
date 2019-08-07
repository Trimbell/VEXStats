package com.trimbell.vexstats.ui.teams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.trimbell.vexstats.services.teams.model.Team

class TeamsViewModel : ViewModel() {

    private val _myTeams: MutableLiveData<MutableList<Team>> = MutableLiveData()
    val myTeams: LiveData<MutableList<Team>> = _myTeams

    init {
        val teams = mutableListOf(
            Team(),
            Team()
        )
        _myTeams.postValue(teams)
    }
}