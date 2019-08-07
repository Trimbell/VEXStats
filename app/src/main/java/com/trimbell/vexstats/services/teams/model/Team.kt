package com.trimbell.vexstats.services.teams.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Team {

    @SerializedName("number")
    @Expose
    var number: String? = null

    @SerializedName("program")
    @Expose
    var program: String? = null

    @SerializedName("team_name")
    @Expose
    var teamName: String? = null

    @SerializedName("robot_name")
    @Expose
    var robotName: String? = null

    @SerializedName("organisation")
    @Expose
    var organisation: String? = null

    @SerializedName("city")
    @Expose
    var city: String? = null

    @SerializedName("region")
    @Expose
    var region: String? = null

    @SerializedName("country")
    @Expose
    var country: String? = null

    @SerializedName("grade")
    @Expose
    var grade: String? = null

    @SerializedName("is_registered")
    @Expose
    var isRegistered: Int? = null

}