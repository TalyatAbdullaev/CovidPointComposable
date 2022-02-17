package com.iwgroup.covidpoint.data.pojo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Timelines(

    @SerialName("confirmed")
    val confirmed: Confirmed?
)