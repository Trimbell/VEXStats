package com.trimbell.vexstats.services.teams.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Team (

    @Expose
    val number: String? = null,

    @Expose
    val program: String? = null,

    @SerializedName("team_name")
    @Expose
    val teamName: String? = null,

    @SerializedName("robot_name")
    @Expose
    val robotName: String? = null,

    @Expose
    val organisation: String? = null,

    @Expose
    val city: String? = null,

    @Expose
    val region: String? = null,

    @Expose
    val country: String? = null,

    @Expose
    val grade: String? = null,

    @SerializedName("is_registered")
    @Expose
    val isRegistered: Int? = null

)