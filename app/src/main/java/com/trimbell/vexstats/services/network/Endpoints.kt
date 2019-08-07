package com.trimbell.vexstats.services.network

import com.trimbell.vexstats.services.events.model.BaseEvent
import com.trimbell.vexstats.services.teams.model.BaseTeam
import retrofit2.Call
import retrofit2.http.GET

interface Endpoints {

    @GET("v1/get_teams")
    fun getTeamList(): Call<BaseTeam>

    @GET("v1/get_events")
    fun getEventList(): Call<BaseEvent>


}