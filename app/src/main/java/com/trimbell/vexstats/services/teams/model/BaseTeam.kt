package com.trimbell.vexstats.services.teams.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseTeam (

    @SerializedName("status")
    @Expose
    var status: Int? = null,

    @SerializedName("size")
    @Expose
    var size: Int? = null,

    @SerializedName("result")
    @Expose
    var result: List<Team>? = null

)