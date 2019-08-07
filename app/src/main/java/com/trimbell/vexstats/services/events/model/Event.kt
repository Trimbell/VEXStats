package com.trimbell.vexstats.services.events.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Event (

    @Expose
    val sku: String? = null,

    @Expose
    val key: String? = null,

    @Expose
    val program: String? = null,

    @Expose
    val name: String? = null,

    @SerializedName("loc_venue")
    @Expose
    val locVenue: String? = null,

    @SerializedName("loc_address1")
    @Expose
    val locAddress1: String? = null,

    @SerializedName("loc_address2")
    @Expose
    val locAddress2: String? = null,

    @SerializedName("loc_city")
    @Expose
    val locCity: String? = null,

    @SerializedName("loc_region")
    @Expose
    val locRegion: String? = null,

    @SerializedName("loc_postcode")
    @Expose
    val locPostcode: String? = null,

    @SerializedName("loc_country")
    @Expose
    val locCountry: Int? = null,

    @Expose
    val season: String? = null,

    @Expose
    val start: String? = null,

    @Expose
    val end: String? = null,

    @Expose
    val divisions: List<String>? = null

)
