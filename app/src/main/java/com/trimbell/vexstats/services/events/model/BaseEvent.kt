package com.trimbell.vexstats.services.events.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseEvent (

    @Expose
    var status: Int? = null,

    @Expose
    var size: Int? = null,

    @Expose
    var result: List<Event>? = null

)