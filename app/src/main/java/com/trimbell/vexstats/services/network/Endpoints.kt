package com.trimbell.vexstats.services.network

import com.trimbell.vexstats.services.teams.model.Team
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoints {

    @GET("v1/get_teams")
    fun getTeamList(): Call<List<Team>>

//    @GET("api/v1/employees/{employeeId}")
//    fun getTeamById(@Path("employeeId") employeeId: Int): Call<Team>


}