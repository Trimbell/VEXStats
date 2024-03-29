package com.trimbell.vexstats.services.teams.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseTeam (

    @Expose
    var status: Int? = null,

    @Expose
    var size: Int? = null,

    @Expose
    var result: List<Team>? = null

)